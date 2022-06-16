package com.example.springwebsocketclients.handler.implement;

import com.example.springwebsocketclients.handler.ClientWebSocketHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class BetaWebSocketHandler implements ClientWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Beta afterConnectionEstablished, session id : {}, session : {}", session.getId(), session.getUri());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.info("Beta handleMessage id : {}, message : {}", session.getId(), message.getPayload());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("Beta handleTransportError");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Beta afterConnectionClosed, session id : {}, status : {}", session.getId(), closeStatus);
    }

    @Override
    public boolean supportsPartialMessages() {
        log.info("Beta supportsPartialMessages");
        return false;
    }
}
