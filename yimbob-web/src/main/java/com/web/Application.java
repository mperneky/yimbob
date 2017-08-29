package com.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * My first spring boot application.
 */
@EnableCircuitBreaker
@SpringBootApplication
public class Application {

    /**
     * Starts the application.
     *
     * @param args arguments passed.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
