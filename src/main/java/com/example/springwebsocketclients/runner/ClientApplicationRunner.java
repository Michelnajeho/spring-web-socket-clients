package com.example.springwebsocketclients.runner;

import com.example.springwebsocketclients.handler.implement.AlphaWebSocketHandler;
import com.example.springwebsocketclients.handler.implement.BetaWebSocketHandler;
import com.example.springwebsocketclients.runner.connector.AlphaConnector;
import com.example.springwebsocketclients.runner.connector.BetaConnector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClientApplicationRunner implements ApplicationRunner {

    private final AlphaWebSocketHandler alphaWebSocketHandler;
    private final BetaWebSocketHandler betaWebSocketHandler;

    @Override
    public void run(ApplicationArguments args) {

        AlphaConnector alphaConnector = new AlphaConnector(alphaWebSocketHandler);
        alphaConnector.start();

        BetaConnector betaConnector = new BetaConnector(betaWebSocketHandler);
        betaConnector.start();

    }
}
