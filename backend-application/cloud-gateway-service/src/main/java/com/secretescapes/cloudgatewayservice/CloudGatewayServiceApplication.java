/**
 * This package contains classes related to the Cloud Gateway Service.
 * The Cloud Gateway Service acts as an entry point for incoming requests and routes them to the appropriate backend services.
 * It provides routing, filtering, and other cross-cutting concerns such as logging and security.
 */
package com.secretescapes.cloudgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudGatewayServiceApplication {

	/**
	 * Main method to start the Cloud Gateway Service application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CloudGatewayServiceApplication.class, args);
	}

}
