/**
 * This package contains classes related to the Favourite Service.
 * The Favourite Service is responsible for managing the favourite functionality for sales.
 * It handles operations such as adding/removing sales to/from the favourites list, retrieving the user's favourites, etc.
 */
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
