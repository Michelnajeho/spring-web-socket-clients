package com.example.springwebsocketclients.runner.connector;

import com.example.springwebsocketclients.common.CustomWebSocketUtils;
import com.example.springwebsocketclients.common.Endpoint;
import com.example.springwebsocketclients.handler.implement.BetaWebSocketHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BetaConnector extends Thread {

    private final BetaWebSocketHandler betaWebSocketHandler;

    public void run() {
        try {
            this.webSocketConnectionChecker();
        } catch (Exception e) {
            log.error("BetaConnector error:{}, type:{}", e.getMessage(), e.getClass().getCanonicalName());
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
    public void webSocketConnectionChecker() throws Exception {

        while (true) {
            if (!CustomWebSocketUtils.alphaIsConnected) {
                CustomWebSocketUtils.connect(Endpoint.BETA, betaWebSocketHandler);
            } else {
                log.info("The BetaConnector status is the connection success status. It monitors the connection every 10 seconds.");
            }
            Thread.sleep(10000);
        }
    }
}
