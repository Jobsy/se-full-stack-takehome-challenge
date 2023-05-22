package com.secretescapes.favouriteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FavouriteServiceApplication {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(FavouriteServiceApplication.class, args);
	}

}
