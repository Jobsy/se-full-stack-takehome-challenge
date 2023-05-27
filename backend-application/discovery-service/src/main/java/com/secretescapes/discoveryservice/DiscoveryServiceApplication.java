/**
 * This package contains classes related to the Discovery Service.
 * The Discovery Service is responsible for service registration and discovery using Eureka Server.
 * It enables services to register themselves and discover other services in the system.
 */
package com.secretescapes.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServiceApplication {

	private DiscoveryServiceApplication() { // Private constructor to prevent instantiation
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Main method to start the Discovery Service application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(final String[] args) {
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}
}
