package com.example.springwebsocketclients.common;

import com.example.springwebsocketclients.handler.ClientWebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.WebSocketHttpHeaders;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

import java.net.URI;

@Slf4j
public class CustomWebSocketUtils {

    private static final String WEB_SOCKET_URL = "wss://socketsbay.com/wss/v2/2/demo";
    public static WebSocketSession alphaWebSocketSession;
    public static WebSocketSession betaWebSocketSession;
    public static boolean alphaIsConnected = false;
    public static boolean betaIsConnected = false;

    public static String getWebSocketUrl(Endpoint endPoint) {
        return switch (endPoint) {
            case ALPHA -> WEB_SOCKET_URL + "/alpha";
            case BETA -> WEB_SOCKET_URL + "/beta";
        };
    }

    public static void isConnected(Endpoint endPoint, WebSocketSession result, boolean check) {
        switch (endPoint) {
            case ALPHA:
                alphaWebSocketSession = result;
                alphaIsConnected = check;
            case BETA:
                betaWebSocketSession = result;
                betaIsConnected = check;
        }
    }

    public static void connect(Endpoint endPoint, ClientWebSocketHandler proxyWebSocketHandler) throws Exception {

        String webSocketUrl = getWebSocketUrl(endPoint);
        if (webSocketUrl != null) {
            ListenableFuture<WebSocketSession> future = new StandardWebSocketClient()
                    .doHandshake(proxyWebSocketHandler, new WebSocketHttpHeaders(), new URI(webSocketUrl));

            future.addCallback(
                    result -> {
                        assert result != null;
                        isConnected(endPoint, result, true);
                        log.info("Web socket connect success, uri : {}", result.getUri());
                    }, ex -> {
                        isConnected(endPoint, null, false);
                        log.error("Web socket connect failed, error : {}, type : {}", ex.getMessage(), ex.getClass().getCanonicalName());
                    }
            );

        } else {
            log.error("Url does not exist. Please add it to getWebSocketUrl().");
        }
    }
}
