package com.example.springwebsocketclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebSocketClientsApplication {

    /**
     * A demo project that can help if you have multiple endpoints on a single Web socket server.
     *
     * Property-related items are commonly defined in 'CustomWebSocketUtils'
     * and can be used by adding endpoint types to Endpoint (Enum class) of that class.
     *
     * @author Mechelanjeho
     * @link   <a href="https://socketsbay.com/test-websockets">...</a> has set up a demo by adding a custom endpoint to the address defined in the sample.
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringWebSocketClientsApplication.class, args);

    }

}
