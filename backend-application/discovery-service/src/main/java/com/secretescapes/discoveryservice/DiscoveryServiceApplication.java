package com.secretescapes.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {

    /**
     * Main method to start the Discovery Service application.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {

        SpringApplication.run(DiscoveryServiceApplication.class, args);
    }

}
