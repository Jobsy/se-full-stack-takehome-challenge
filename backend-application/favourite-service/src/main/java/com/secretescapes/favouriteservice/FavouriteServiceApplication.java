package com.secretescapes.favouriteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FavouriteServiceApplication {

    /**
     * Entry point of the Favourite Service application.
     *
     * @param args The command line arguments.
     */
    @LoadBalanced
    public static void main(final String[] args) {
        SpringApplication.run(FavouriteServiceApplication.class, args);
    }

}
