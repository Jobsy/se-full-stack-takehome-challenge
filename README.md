[![CI/CD Pipeline](https://github.com/Jobsy/se-full-stack-takehome-challenge/actions/workflows/ci-cd.yml/badge.svg)](https://github.com/Jobsy/se-full-stack-takehome-challenge/actions/workflows/ci-cd.yml)

[![Snyk Security](https://github.com/Jobsy/se-full-stack-takehome-challenge/actions/workflows/snyk-security.yml/badge.svg)](https://github.com/Jobsy/se-full-stack-takehome-challenge/actions/workflows/snyk-security.yml)

[![Lint Code Base](https://github.com/Jobsy/se-full-stack-takehome-challenge/actions/workflows/superlinter.yml/badge.svg)](https://github.com/Jobsy/se-full-stack-takehome-challenge/actions/workflows/superlinter.yml)

# Secret Escapes Full stack engineer take home task

This project is a starting point for the fullstack engineer technical interview take home task.
It consists of a Frontend (with some functionality already build) and a backend application (to be created by you).

## Frontend application

The frontend application is build using Create react app and is a simple react app using typescript.

### Prerequisites

- Node (version 14+)
- Yarn (modern version)

### To install dependencies

From the `frontend-application` directory and `yarn`

### To start the application

From the `frontend-application` directory run `yarn start`

This runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

### Project overview

- `.env` contains URL for Sparrow graphql API
- `index.tsx` is where the application is set up, including the configuration of Apollo client
- `App.tsx` is the root of the application, and where URL routing is configured
- `UserContext` is set up in `App`, this means you can access the user ID in any component via this context
- `pages` directory contains the top-level components which form the contents of each page
- `components` directory contains other reusable components
- `layout` contains the main layout for the page including menu bar
- `utils` contains helper functions to perform data fetching

## Backend application

The `backend-application` directory is a placeholder for your new microservice. Please update this section of the read me with instructions on how to run the service.

## Implementation Comments

Please add any comments on choices you have made, any missed functionally or known bugs and what you would improve or do differently given more time if you were to make this solution production-ready.



# Table of Contents

- [Checklist](#checklist)
  - [MVP Checklist](#mvp-checklist)
    - [Backend](#backend)
    - [Frontend](#frontend)
    - [General](#general)
    - [Technical Details](#technical-details)
    - [Additional Notes](#additional-notes)
  - [Stretch Goals Checklist](#stretch-goals-checklist)
- [Script](#script)
- [Microservices: Cloud Gateway, Discovery Service, and Favourite](#microservices-cloud-gateway-discovery-service-and-favourite)
  - [Overview](#overview)
  - [Cloud Gateway](#cloud-gateway)
  - [Discovery Service](#discovery-service)
  - [Favourite Service](#favourite-service)
  - [MySQL Database](#mysql-database)
- [Microservices Deployment](#microservices-deployment)
  - [Manual Startup](#manual-startup)
  - [Docker Startup](#docker-startup)
  - [Running the microservices in Docker Compose](#running-the-microservices-in-docker-compose)
  - [Conclusion](#conclusion)
- [Microservices Docker Image Push](#microservices-docker-image-push)
  - [Manual Docker Image Push](#manual-docker-image-push)
  - [Docker Image Push with Google Jib](#docker-image-push-with-google-jib)
  - [Conclusion](#conclusion-1)
- [MySQL Workbench Setup (Connection-type: Standard TCP/IP)](#mysql-workbench-setup-connection-type-standard-tcpip)
  - [Prerequisites](#prerequisites)
  - [Setup for Local Development](#setup-for-local-development)
  - [Setup for Docker Development](#setup-for-docker-development)
  - [Conclusion](#conclusion-2)
- [MicroService API Documentation](#microservice-api-documentation)
  - [Zipkin API Documentation](#zipkin-api-documentation)
    - [Local Environment](#local-environment)
      - [Installation](#installation)
      - [Authentication](#authentication)
      - [Error Handling](#error-handling)
      - [Endpoints](#endpoints)
    - [Docker Environment](#docker-environment)
      - [Installation](#installation-1)
      - [Authentication](#authentication-1)
      - [Error Handling](#error-handling-1)
      - [Endpoints](#endpoints-1)
    - [Accessing the Zipkin UI](#accessing-the-zipkin-ui)
    - [Dependencies](#dependencies)
  - [Cloud Gateway API Documentation](#cloud-gateway-api-documentation)
    - [Local Environment](#local-environment-1)
      - [Base URL](#base-url)
      - [Authentication](#authentication-2)
      - [Error Handling](#error-handling-2)
      - [Endpoints](#endpoints-2)
    - [Docker Environment](#docker-environment-1)
      - [Base UR](#base-ur)
      - [Application Properties](#application-properties)
      - [Major Dependencies](#major-dependencies)
    - [CORS Configuration for Cloud Gateway Service](#cors-configuration-for-cloud-gateway-service)
      - [Configuration Details](#configuration-details)
      - [Default Filters](#default-filters)
      - [Global CORS Configurations](#global-cors-configurations)
      - [Error Handling](#error-handling-3)
      - [Example Usage](#example-usage)
      - [Major Dependencies](#major-dependencies-1)
  - [Discovery Service API Documentation](#discovery-service-api-documentation)
    - [Local Environment](#local-environment-2)
      - [Base URL](#base-url-1)
      - [Authentication](#authentication-3)
      - [Error Handling](#error-handling-4)
      - [Endpoints](#endpoints-3)
    - [Docker Environment](#docker-environment-2)
      - [Application Properties](#application-properties-1)
      - [Major Dependencies](#major-dependencies-2)
  - [Favourite Service API Documentation](#favourite-service-api-documentation)
    - [Local Environment](#local-environment-3)
      - [Base URL](#base-url-2)
      - [Authentication](#authentication-4)
      - [Error Handling](#error-handling-5)
      - [API Endpoints](#api-endpoints)
    - [Docker Environment](#docker-environment-3)
      - [Base URL](#base-url-3)
      - [Authentication](#authentication-5)
      - [Error Handling](#error-handling-6)
      - [Endpoints](#endpoints-4)
    - [Configuration](#configuration)
      - [Application Properties](#application-properties-2)
      - [Major Dependencies](#major-dependencies-3)
    - [Additional Notes](#additional-notes-1)
  - [Conclusion](#conclusion-3)
- [Troubleshooting](#troubleshooting)
  - [Issue: Microservice fails to start or connect to dependencies](#issue-microservice-fails-to-start-or-connect-to-dependencies)
  - [Issue: API requests fail or return errors](#issue-api-requests-fail-or-return-errors)
  - [Issue: Database Connection Failure](#issue-database-connection-failure)
  - [Issue: Dependency Version Conflict](#issue-dependency-version-conflict)
  - [Issue: Service Discovery Failure](#issue-service-discovery-failure)
  - [Issue: Performance Degradation](#issue-performance-degradation)
  - [Issue: Security Vulnerabilities](#issue-security-vulnerabilities)
  - [Issue: Database connection or data access errors](#issue-database-connection-or-data-access-errors)
  - [Issue: MySQL Workbench setup errors](#issue-mysql-workbench-setup-errors)
  - [Issue: MySQL Workbench SSH connection failed](#issue-mysql-workbench-ssh-connection-failed)
  - [Issue: MySQL Workbench connection timeout or slow connection](#issue-mysql-workbench-connection-timeout-or-slow-connection)
  - [Issue: MySQL Workbench access denied error](#issue-mysql-workbench-access-denied-error)
  - [Issue: Zipkin UI is not accessible](#issue-zipkin-ui-is-not-accessible)
  - [Issue: Traces are not appearing in Zipkin](#issue-traces-are-not-appearing-in-zipkin)
  - [Issue: High latency or slow performance in tracing](#issue-high-latency-or-slow-performance-in-tracing)
  - [Conclusion](#conclusion-4)
- [CI/CD](#cicd)
- [Code Structure](#code-structure)


# Checklist

## MVP Checklist

Below are checked boxes to mark the completion of each task for the Minimum Viable Product (MVP) implementation.

### Backend

- [x] Create a new 'favourites' microservice backend using your preferred tech stack (NodeJS or JVM-based technology).
- [x] Implement functionality to allow logged-in users to mark sales as favourites.
- [x] Store favourite sales data persistently in a backend service (using your choice of persistence technology).
- [x] Expose API endpoints to add/remove sales from the favourites list and retrieve the user's favourite sales.
- [x] Persist data to the backend service rather than storing it in the browser.
- [x] Ensure the backend communicates with the frontend using your preferred API technology (REST, GraphQL, tRPC).

### Frontend

- [x] Add a favourite button to the sale lists and sale details page for logged-in users.
- [x] Implement a toggle functionality for the favourite button to add/remove a sale to/from the favourites list for the user.
- [x] Implement functionality to toggle the favourite status of a sale when the favourite button is clicked.
- [x] Update the favourites button to reflect the correct state for each sale based on the user's favourites.
- [x] Ensure the favourites button reflects the correct state for each sale (e.g., different color or text based on whether it's saved as a favourite).
- [x] Create a new page at `/favourites` to display all sales that the user has saved as favourites.
- [x] Add a link to the favourites page in the navigation bar for easy access.
- [x] Enable logged-in users to see a `favourite` button on all sale lists and the sale details page.
- [x] Hide the favourites functionality for logged-out users.
- [x] Persist data to a backend service rather than saving it in the browser.
- [x] Update the frontend code to interact with the new backend service and add the required user-facing functionality.
- [x] Modify the frontend application to support the new favourites functionality.
- [x] Minimize significant changes/refactors to the existing functionality.
- [x] Only update the frontend code necessary to support the new functionality.
- [x] Maintain compatibility with the existing faux 'login' functionality.

### General

- [x] Ensure the favourite functionality is only visible to logged-in users.
- [x] Provide clear instructions in the README file on how to run the application.
- [x] Include details of any known bugs or missing features in the README.
- [x] Explain the technical choices made, including the backend tech stack, persistence technology, and API technology.
- [ ] Discuss what additional steps would be taken to make the solution production-ready.
- [x] Provide the code either via a link to a git repository or in a zip file.

### Technical Details

- [x] Backend application built using JVM-based technology.
- [x] Preferred persistence technology - MySQL with instructions on how to run it locally.
- [x] Both REST and GraphQL API technology was used for communication between frontend and backend.
- [x] Use any external libraries/dependencies deemed necessary.
- [x] Provide clear instructions on how to run the application as a standalone project in the README.
- [x] Update the README with known bugs or missing features, technical choices made, and improvements for a production-ready solution.
- [x] Include any other relevant or helpful information for assessing the solution.

### Additional Notes

- Security/authentication/authorization is not required for this task.
- Unit tests are not required. But some linter and github-action jobs are integrated to ensure code quality
- Technical choices made are as follows:

**MySQL:**
I chose MySQL for its replication and high availability features, which are essential for the constant state changes in the Favourite service.

**REST API at the Backend:**
- Simplicity: REST follows a straightforward architectural style using simple HTTP methods (GET, POST, PUT, DELETE) for resource interaction.
- Caching: RESTful APIs have good support for caching mechanisms, improving performance and reducing network traffic.
- Compatibility: REST works seamlessly with existing web technologies and infrastructure, leveraging the widely supported HTTP protocol.
- Strong typing and validation: RESTful APIs can utilize strong typing and validation mechanisms for enhanced data integrity and reliability.
- Flexibility: REST allows clients to request only the required data, reducing over-fetching and optimizing network usage.
- Ecosystem and Tooling: REST has a mature ecosystem with a wide range of tools, libraries, and frameworks available.
in summary, REST API was used at the backend for its simplicity, caching support, compatibility with existing web technologies, strong typing and validation, flexibility, and the mature ecosystem and tooling available.

**Both REST and GraphQL at the Frontend:**
- For simple requests and data posting, REST APIs were used for their simplicity and compatibility.
- For complex and bespoke fetches like "useFetchFavouriteSale", GraphQL was chosen for efficient data fetching, flexible queries, schema typing, and rapid iteration.

## Stretch Goals Checklist
Below are checked boxes to mark the completion of each task for stretch goals implementation
- [x] Add GitHub Actions for CI/CD, Snyk, and SuperLinter.
- [x] Add additional services: Discovery/Eureka service, Cloud Gateway service, and Zipkin.

# Script
TODO: add ports and package.json scripts for dynamically starting the app.
To use the app for now, you have to change the post to 8080 when running locally and to 8181 when running with docker compose.

# Microservices: Cloud Gateway, Discovery Service, and Favourite

## Overview
This project consists of three microservices: Cloud Gateway Service, Discovery Service, and Favourite Service. These microservices work together to provide a scalable, fault-tolerant, and highly available application architecture. This README.md file provides a detailed overview of each microservice, including their purpose, technologies used, setup instructions, and API documentation.

## Cloud Gateway
- **Description:** The Cloud Gateway Service microservice acts as a central entry point for all incoming requests. It handles routing, load balancing, and security features, providing a unified interface to access the application's backend microservices.
- **Technologies:** Java, Spring Cloud Gateway, Docker
- **Dependencies:** Discovery Service
- **Setup Instructions:**
  - **Prerequisites:** Ensure that Java and Docker are installed on your system.
  - **Clone the Repository:** `git clone https://github.com/Jobsy/se-full-stack-takehome-challenge`
  - **Navigate to the Cloud Gateway Directory:** `cd cloud-gateway-service`
  - **Build the Docker Image:** `docker build -t cloud-gateway-service .`
  - **Run the Docker Container:** `docker run -p 8181:8080 cloud-gateway-service`
- **API Documentation:** [Link to API documentation for the Cloud Gateway microservice]

## Discovery Service
- **Description:** The Discovery Service microservice provides service discovery and registration capabilities to enable dynamic communication between microservices. It helps in locating and load balancing instances of other microservices in the system.
- **Technologies:** Java, Spring Cloud Netflix Eureka, Docker
- **Setup Instructions:**
  - **Prerequisites:** Ensure that Java and Docker are installed on your system.
  - **Clone the Repository:** `git clone https://github.com/Jobsy/se-full-stack-takehome-challenge`
  - **Navigate to the Discovery Service Directory:** `cd discovery-service`
  - **Build the Docker Image:** `docker build -t discovery-service .`
  - **Run the Docker Container:** `docker run -p 8761:8761 discovery-service`
- **API Documentation:** [Link to API documentation for the Discovery Service microservice]

## Favourite Service
- **Description:** The Favourite Service microservice manages user favorites for various items within the application. It provides functionalities for creating, retrieving, updating, and deleting favorite items. It basically provides CRUD operations for managing favorite items.
- **Technologies:** Java, Spring Boot, MySQL, Docker
- **Dependencies:** Discovery Service, MySQL Database
- **Setup Instructions:**
  - **Prerequisites:** Ensure that Java, Docker, and MySQL are installed on your system.
  - **Clone the Repository:** `git clone https://github.com/Jobsy/se-full-stack-takehome-challenge`
  - **Navigate to the Favourite Directory:** `cd favourite-service`
  - **Build the Docker Image:** `docker build -t favourite-service .`
  - **Run the Docker Container:** `docker run -p 8082:8082 favourite-service`
- **API Documentation:** [Link to API documentation for the Favourite microservice]

## MySQL Database
- Description: The MySQL database is used by the Favourite Service microservice to store user favorite items.
- Setup Instructions:
  - Prerequisites: Ensure that MySQL is installed on your system.
  - Create a new MySQL database: `CREATE DATABASE favourite_db;`
  - Configure the database connection in the application.properties file of the Favourite microservice.
  - Start the MySQL server: `mysql.server start`


# Microservices Deployment

This [repository](https://github.com/Jobsy/se-full-stack-takehome-challenge) contains multiple microservices that make up the application. You can choose to start each microservice manually or use Docker Compose to start all the microservices at once.

## Manual Startup

To start each microservice manually, follow these steps:

1. Ensure that the necessary prerequisites are installed, including Java, Maven, and MySQL.
2. Clone this [repository](https://github.com/Jobsy/se-full-stack-takehome-challenge) to your local machine.
```
git clone https://github.com/Jobsy/se-full-stack-takehome-challenge
```
3. Navigate to the root directory of each microservice using the command line.
```
cd <microservice name>
```
4. Build the microservice using Maven by running the following command:
```
mvn clean package
```
OR
```
mvn clean install
```
5. Start the microservice by executing the generated JAR file or using the appropriate command specific to each microservice. For example:
```
java -jar target/<microservice-name>.jar
```
OR
```
mvn spring-boot:run
```
6. The Favourite service will be available at `http://localhost:<port>/<microservice name>`.
7. Repeat steps 3-5 for each microservice, starting them in the required order based on their dependencies.

## Docker Startup
To start the microservices using Docker, follow these steps:

1. Ensure that you have Docker and Docker Compose installed and running on your machine.
2. Clone this repository to your local machine.
```
git clone https://github.com/Jobsy/se-full-stack-takehome-challenge
```
3. Navigate to the root directory of the project using the command line.
```
cd <microservice name>
```
4. Build the Docker image:
```
docker build -t <microservice name> .
```
5. Run the Docker container:
```
docker run -p <host-port>:<container-port> --name <microservice name> <microservice name>
```
Replace `<host-port>` with the desired port on the host machine and `<container-port>` with the port specified in the `application.properties` or `application-docker.properties` file.
6. The Favourite service will be available at `http://localhost:<host-port>/<microservice name>`.
7. Repeat steps 3-5 for each microservice, starting them in the required order based on their dependencies.

## Running the microservices in Docker Compose
Alternatively, you can use Docker Compose to start all the microservices at once. Docker Compose allows you to define the services and their dependencies in a single YAML file (which has already been done.)

To start the microservices using Docker Compose, follow these steps:
1. Open the `docker-compose.yml` file and review the configuration.
2. Customize the configuration if necessary, such as the exposed ports or environment variables.
3. Start the microservices using the following command:
```
docker compose up
```
This command will build and start all the microservices defined in the `docker-compose.yml` file.
4. Wait for the services to start. You should see the logs of each microservice in the console.
5. Access the application by opening a web browser and navigating to the specified URL or port.
6. Shut down the microservices using the following command:
```
docker compose down
```
7. List running containers using the following command:
```
docker ps
```
8. Stop the containers using the following command:
```
docker stop <container-id>
```
9. Delete the containers using the following command:
```
docker rm <container-id>
```
10. Delete the images used by the containers using the following command:
```
docker rmi <image-id>
```
11. Delete the volumes used by the containers using the following command:
```
docker volume rm <volume-name>
```
12. Delete the networks used by the containers using the following command:
```
docker network rm <network-name>
```
13. Delete the images used by the containers using the following command:
```
docker image rm <image-id>
```

Note: If you need to stop the running microservices started with Docker Compose, press `Ctrl + C` in the command line window where the services are running. Some of the command might not be needed but it is good to have them listed.

## Conclusion

You now have two options for starting the microservices: manually or using Docker Compose. Choose the method that best fits your requirements and development environment. If you encounter any issues during the startup process, please refer to the troubleshooting section in the README or contact the project team for assistance.

# Microservices Docker Image Push

This [repository](https://github.com/Jobsy/se-full-stack-takehome-challenge) contains multiple microservices that can be deployed as Docker containers. You can choose to push the microservices to Docker Hub manually or use Google Jib to simplify the process.

## Manual Docker Image Push

To manually push the microservices to Docker Hub, follow these steps:

1. Ensure that you have Docker installed and authenticated with your Docker Hub account.
2. Clone this [repository](https://github.com/Jobsy/se-full-stack-takehome-challenge) to your local machine.
3. Navigate to the root directory of each microservice using the command line.
4. Build the Docker image for each microservice by running the following command:
```
docker build -t <docker-hub-username>/<microservice-name>:<tag> .
```
Replace `<docker-hub-username>` with your Docker Hub username, `<microservice-name>` with the name of the microservice, and `<tag>` with the desired tag for the image.
5. Once the image is built, push it to Docker Hub using the following command:
```
docker push <docker-hub-username>/<microservice-name>:<tag>
```
This will push the image to your Docker Hub repository.

Repeat steps 3-5 for each microservice that you want to push to Docker Hub.

## Docker Image Push with Google Jib

Alternatively, you can use Google Jib to simplify the process of building and pushing Docker images. Jib is a Java containerizer that allows you to build optimized Docker and OCI images without requiring a Docker daemon.

To push the microservices to Docker Hub using Google Jib, follow these steps:

1. Ensure that you have Docker installed and authenticated with your Docker Hub account.
2. Clone this [repository](https://github.com/Jobsy/se-full-stack-takehome-challenge) to your local machine.
3. Navigate to the root directory of each microservice using the command line.
4. Open the `pom.xml` file of each microservice and add the Jib Maven plugin configuration.
```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.google.cloud.tools</groupId>
            <artifactId>jib-maven-plugin</artifactId>
            <version>3.1.1</version>
            <configuration>
                <to>
                    <image><docker-hub-username>/<microservice-name>:<tag></image>
                </to>
            </configuration>
        </plugin>
    </plugins>
</build>
```
Replace <docker-hub-username> with your Docker Hub username, <microservice-name> with the name of the microservice, and <tag> with the desired tag for the image.
5. Run the following command to build and push the Docker image using Jib:
```
mvn clean compile jib:build
```

This will build the Docker image using Jib and push it to your Docker Hub repository.

Repeat steps 3-5 for each microservice that you want to push to Docker Hub.

## Conclusion
You now have two options for pushing the microservices to Docker Hub: manually or using Google Jib. Choose the method that best fits your requirements and development environment.


# MySQL Workbench Setup (Connection-type: Standard TCP/IP)

This guide will walk you through the process of setting up MySQL Workbench to access a MySQL database in both local development and Docker development environments using the Standard TCP/IP connection type.

## Prerequisites

Before proceeding with the setup, ensure that you have the following:
- MySQL Workbench installed on your machine. You can download it from the official MySQL website: [MySQL Workbench Downloads](https://dev.mysql.com/downloads/workbench/)

## Setup for Local Development

To connect MySQL Workbench to a locally running MySQL database, follow these steps:

1. Launch MySQL Workbench.
2. Click on the "+" button next to "MySQL Connections" in the "MySQL Connections" panel to open the "Set up a New Connection" dialog.
3. In the "Connection Name" field, enter a name for your connection (e.g., "Local MySQL").
4. In the "Connection Method" section, select "Standard TCP/IP".
5. In the "MySQL Hostname" field, enter `127.0.0.1`.
6. In the "MySQL Server Port" field, enter the port number on which your MySQL server is running (usually `3306` by default).
7. In the "Username" field, enter your MySQL username.
8. In the "Password" field, enter your MySQL password.
9. Click the "Test Connection" button to verify the connection.
10. If the connection is successful, click "OK" to save the connection.
You can now use the "Local MySQL" connection to access your locally running MySQL database using MySQL Workbench.

## Setup for Docker Development

To connect MySQL Workbench to a MySQL database running in a Docker container, is similar to that of the local set. Only difference is to ensure that the port matches that of the doker.

You can now use the "Docker MySQL" connection to access your MySQL database running inside a Docker container using MySQL Workbench.

## Conclusion

You have successfully set up MySQL Workbench to access a MySQL database in both local development and Docker development environments using the Standard TCP/IP connection type. You can now easily manage and interact with your databases using MySQL Workbench.

For more detailed instructions and information about using MySQL Workbench, please refer to the official [MySQL Workbench Documentation](https://dev.mysql.com/doc/workbench/en/).

# MicroService API Documentation

## Zipkin API Documentation

Zipkin is a distributed tracing system that helps gather timing data needed to troubleshoot latency problems in microservice architectures. This documentation provides instructions for installing and running Zipkin in both local and Docker environments.

### Local Environment

#### Installation

To install and run Zipkin in your local environment, follow these steps:

1. Download the Zipkin server JAR file from the official Zipkin GitHub repository:
```
https://github.com/openzipkin/zipkin/releases/download/v2.13.0/zipkin-server-2.13.0.jar
```
2. Run the Zipkin server:
```
java -jar zipkin-server-2.13.0.jar
```
Or simply run step 1 & 2 with one click on the terminal using the command below:
```
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar
```
Zipkin will start running on port 9411 by default.
3. Verify that the Zipkin server is running:
```
curl -s http://localhost:9411/api/v2/spans | jq
```
4. Stop the Zipkin server:
```
java -jar zipkin-server-2.13.0.jar stop
```

#### Authentication

Authentication is not required for accessing the Zipkin UI in the local environment.

#### Error Handling

If an error occurs, Zipkin will return an appropriate HTTP status code along with a corresponding error message.

#### Endpoints

No specific endpoints are exposed by the Zipkin server. The functionality is accessed through the web UI.

### Docker Environment

#### Installation

To install and run Zipkin in a Docker environment, follow these steps:

1. Pull the Zipkin Docker image from the Docker Hub:
```
docker pull openzipkin/zipkin
```
2. Run the Zipkin Docker container:
```
docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin
```
This command starts the Zipkin container and maps port 9411 from the container to the same port on the host.
```
http://<docker-host>:9411
```

Replace `<docker-host>` with the hostname or IP address of your Docker environment.

#### Authentication

Authentication is not required for accessing the Zipkin UI in the Docker environment.

#### Error Handling

If an error occurs, Zipkin will return an appropriate HTTP status code along with a corresponding error message.

#### Endpoints

No specific endpoints are exposed by the Zipkin server. The functionality is accessed through the web UI.

### Accessing the Zipkin UI

Once Zipkin is up and running, you can access the web UI using the base URL mentioned above. The UI provides a user-friendly interface to view and analyze distributed tracing data.

### Dependencies

Zipkin has no external dependencies.

## Cloud Gateway API Documentation

The Cloud Gateway service acts as an API gateway and provides routing and load balancing for microservices.

### Local Environment

#### Base URL
```
http://localhost:8080
```

#### Authentication

Authentication is not required for accessing the endpoints in the local environment.

#### Error Handling

If an error occurs, the API will return an appropriate HTTP status code along with a JSON response containing an error message.

#### Endpoints

No specific endpoints are exposed by the Cloud Gateway service itself. It acts as a proxy to forward requests to the appropriate microservices based on the defined routes.

### Docker Environment

#### Base URL
```
http://localhost:8181
```
Every other things are same as local

#### Application Properties

- For the local environment, the application properties are located in `application.properties`.
- For the Docker environment, the application properties are located in `application-docker.properties`.

Make sure to configure the necessary properties such as the service routes and discovery service URL according to your environment.

#### Major Dependencies
The Cloud Gateway Service API has the following dependencies:
- Spring Boot
- Spring Cloud Gateway
- Spring Cloud Netflix Eureka Client
- Spring Cloud Sleuth
- Reactor Net
Make sure to have these dependencies available in your environment.

### CORS Configuration for Cloud Gateway Service

The Cloud Gateway service uses CORS (Cross-Origin Resource Sharing) configuration to control access to its resources from different origins. This documentation provides an overview of the CORS configuration used in the Cloud Gateway service.

#### Configuration Details

The following CORS configuration is applied in the Cloud Gateway service:

#### Default Filters

The Cloud Gateway service applies the following default filters to handle CORS:

- `DedupeResponseHeader`: This filter ensures that the `Access-Control-Allow-Credentials` and `Access-Control-Allow-Origin` response headers are included in the HTTP responses. These headers enable credentials and specify the allowed origin for cross-origin requests.

- `AddResponseHeader`: This filter adds the `Access-Control-Allow-Origin` header to the HTTP responses with the value `*`, allowing requests from all origins.

#### Global CORS Configurations
The Cloud Gateway service has the following global CORS configurations:
- `spring.cloud.gateway.default-filters[0]=DedupeResponseHeader=Access-Control-Allow-Credentials Access-Control-Allow-Origin`: Adds the necessary headers to allow credentials and specify the allowed origin for CORS requests.

- `spring.cloud.gateway.default-filters[1]=AddResponseHeader=Access-Control-Allow-Origin, *`: Adds the `Access-Control-Allow-Origin` header to all responses, allowing requests from any origin. This configuration is not recommended for production environments and is used here for demonstration purposes.

- `spring.cloud.gateway.globalcors.cors-configurations[/**].allowedOrigins[0]=http://localhost:3000`: Specifies that requests from `http://localhost:3000` are allowed to access resources in the Cloud Gateway service. You can modify this configuration to include the appropriate origin(s) for your application.

- `spring.cloud.gateway.globalcors.cors-configurations[/**].allowedMethods=*`: Allows all HTTP methods (`GET`, `POST`, `PUT`, etc.) for CORS requests to the Cloud Gateway service. You can restrict the allowed methods based on your application's requirements.

- `spring.cloud.gateway.globalcors.cors-configurations[/**].allowedHeaders=*`: Allows all headers for CORS requests to the Cloud Gateway service. You can restrict the allowed headers based on your application's requirements.

- `spring.cloud.gateway.globalcors.cors-configurations[/**].allowCredentials=true`: Allows the use of credentials (e.g., cookies, authorization headers) in CORS requests to the Cloud Gateway service. This configuration enables the service to handle authenticated requests.

#### Error Handling

If a CORS request is made from an origin that is not allowed or if the request violates the configured CORS policies, the Cloud Gateway service will return an appropriate HTTP status code along with a CORS-related error message.

#### Example Usage

To use the Cloud Gateway service with CORS, make sure to include the appropriate `Origin` header in your requests. Here's an example of making a CORS request to the service:
```
GET /favourites HTTP/1.1
Host: cloud-gateway-service.example.com
Origin: http://localhost:3000
```

The `Origin` header should match one of the allowed origins configured in the Cloud Gateway service. If the request is allowed, the service will include the necessary CORS headers in the response.

#### Major Dependencies

The CORS configuration in the Cloud Gateway service relies on the Spring Cloud Gateway framework and does not have any additional external dependencies.

## Discovery Service API Documentation

The Discovery Service is responsible for service registration and discovery using Eureka.

### Local Environment

#### Base URL
```
http://localhost:8761
```

#### Authentication

Authentication is not required for accessing the endpoints in the local environment.

#### Error Handling

If an error occurs, the API will return an appropriate HTTP status code along with a JSON response containing an error message.

#### Endpoints

No specific endpoints are exposed by the Discovery Service.

### Docker Environment
Same as local

#### Application Properties

- For the local environment, the application properties are located in `application.properties`.
- For the Docker environment, the application properties are located in `application-docker.properties`.

Make sure to configure the necessary properties such as the service routes and discovery service URL according to your environment.

#### Major Dependencies
The Cloud Gateway Service API has the following dependencies:
- Spring Boot
- Spring Cloud Netflix Eureka Server
- Spring Cloud Sleuth
- Zipkin (for distributed tracing)
Make sure to have these dependencies available in your environment.

## Favourite Service API Documentation

The Favourite Service API provides endpoints that allows users to manage their favorite items.

### Local Environment

#### Base URL
```
http://localhost:0
```

#### Authentication

Authentication is not required for accessing the endpoints in the local environment.

#### Error Handling

If an error occurs, the API will return an appropriate HTTP status code along with a JSON response containing an error message.

#### API Endpoints

##### Get Favorites by User ID and Sale ID

Retrieves the favorite item for a given user ID and sale ID.

- **URL**: `/favourites/getFavoritesByUserIdAndSaleId/{userId}/{saleId}`
- **Method**: GET
- **URL Parameters**:
  - `userId` (required): The ID of the user.
  - `saleId` (required): The ID of the sale.
- **Success Response**:
  - **Code**: 200 (OK)
  - **Content**: JSON object representing the favorite item.
- **Error Responses**:
  - **Code**: 500 (Internal Server Error)
  - **Content**: Error message indicating the failure.

##### Get All Favorites by User ID

Retrieves all favorite items for a given user ID.

- **URL**: `/favourites/getAllFavoritesByUserId/{userId}`
- **Method**: GET
- **URL Parameters**:
  - `userId` (required): The ID of the user.
- **Success Response**:
  - **Code**: 200 (OK)
  - **Content**: JSON array representing the list of favorite items.
- **Error Responses**:
  - **Code**: 500 (Internal Server Error)
  - **Content**: Error message indicating the failure.

##### Add Favorite

Adds a new favorite item for a user.

- **URL**: `/favourites/add`
- **Method**: POST
- **Request Body**: JSON object with the following fields:
  - `userId` (required): The ID of the user.
  - `saleId` (required): The ID of the sale.
- **Sample Request**
```
{
"userId": "oluwajoba",
"saleId": "A0234"
}
```
- **Success Response**:
  - **Code**: 200 (OK)
  - **Content**: Success message indicating that the favorite item was added successfully.
- **Error Responses**:
  - **Code**: 500 (Internal Server Error)
  - **Content**: Error message indicating the failure.

##### Remove Favorite

Removes a favorite item for a given user ID and sale ID.

- **URL**: `/favourites/delete/{userId}/{saleId}`
- **Method**: DELETE
- **URL Parameters**:
  - `userId` (required): The ID of the user.
  - `saleId` (required): The ID of the sale.
- **Success Response**:
  - **Code**: 200 (OK)
  - **Content**: Boolean value indicating whether the favorite item was successfully removed.
- **Error Responses**:
  - **Code**: 500 (Internal Server Error)
  - **Content**: Error message indicating the failure.

### Docker Environment

#### Base URL
http://localhost:8181

#### Authentication

Authentication is not required for accessing the endpoints in the Docker environment.

#### Error Handling

If an error occurs, the API will return an appropriate HTTP status code along with a JSON response containing an error message.

#### Endpoints

The endpoints in the Docker environment are the same as in the local environment.

Refer to the local environment section for the detailed documentation of each endpoint.

### Configuration

#### Application Properties

- For the local environment, the application properties are located in `application.properties`.
- For the Docker environment, the application properties are located in `application-docker.properties`.

Make sure to configure the necessary properties such as the database connection details and service URLs according to your environment. It is advisable to stick with the default configuration.

#### Major Dependencies
The Favourite Service API has the following dependencies:
- Spring Boot
- Spring Data JPA
- MySQL Connector
- Lombok
- Jakarta Persistence
- Spring Cloud Netflix Eureka Client
- Spring Cloud Sleuth
- Spring Cloud Zipkin Client
Make sure to have these dependencies available in your environment.

### Additional Notes
- The Favourite service uses the MySQL database for data storage. Make sure to configure the database connection details in the `application.properties` or `application-docker.properties` file or just stick with the default configurations
- The service is registered with Eureka discovery service at `http://discovery-service:8761/eureka`. Modify the `eureka.client.serviceUrl.defaultZone` property in the `application-docker.properties` file if needed.
- Distributed tracing is enabled with Zipkin. The traces are sent to `http://zipkin:9411/api/v2/spans`. Adjust the `management.zipkin.tracing.endpoint` property in the `application-docker.properties` file if necessary.

## Conclusion
This README.md file provides a detailed overview of the Cloud Gateway, Discovery Service, and Favourite microservices. Follow the provided setup instructions to run the microservices and connect them to the MySQL database.

# Troubleshooting

## Issue: Microservice fails to start or connect to dependencies
- **Symptoms:** When starting a microservice, it fails to start or connect to its dependencies.
- **Possible Causes:** This issue can occur due to various reasons, such as incorrect configuration, conflicting ports, or unavailability of dependencies.
- **Troubleshooting Steps:**
  1. Verify that all the prerequisites are installed correctly and meet the minimum requirements.
  2. Double-check the configuration files (e.g., application.properties, Dockerfile) for any errors or inconsistencies.
  3. Ensure that the dependencies (e.g., discovery service, MySQL database) are running and accessible.
  4. Check if there are any conflicts with the ports specified in the setup instructions. Ensure that the ports are not being used by other services or applications.
  5. Review the logs and error messages to identify any specific issues or exceptions thrown during startup.
  6. Search the project's issue tracker or community forums for similar problems and potential solutions.

## Issue: API requests fail or return errors
- **Symptoms:** API requests to a microservice fail or return error responses.
- **Possible Causes:** There can be various causes for API request failures, such as incorrect endpoint URLs, authentication issues, or internal server errors.
- **Troubleshooting Steps:**
  1. Ensure that the microservice is running and accessible at the specified URL.
  2. Verify that the API request includes the correct endpoint URL, HTTP method, and required parameters.
  3. Check if any authentication or authorization mechanisms are in place. Ensure that the request includes valid credentials or tokens if required.
  4. Review the API documentation to understand the expected request format and possible error responses.
  5. Inspect the response headers and body for any error messages or status codes that can provide insight into the issue.
  6. If the issue persists, gather relevant information (e.g., request details, error messages) and consult the project team or community for assistance.

## Issue: Database Connection Failure
- **Symptoms:** Microservice fails to connect to the database or return Error message: "Connection refused" or "Database connection error."
- **Possible Causes:** Incorrect database credentials or connection configuration. Database server is not running or accessible. Network or firewall restrictions preventing the microservice from connecting to the database.
- **Troubleshooting Steps:**
  1. Check database configuration in the microservice's configuration file.
  2. Ensure the database server is running and accessible.
  3. Verify the database credentials (username, password) are correct.
  4. Ensure the microservice has proper network access to the database server (firewall rules, network configurations).
  5. Test the database connection using a database client or command-line tool.
  6. Review the database server logs for any error messages or indications of connection issues.
  7. If using containerized environments, ensure that the microservice and the database container are connected to the same network.

## Issue: Dependency Version Conflict
- **Symptoms:** Microservice fails to start or encounters runtime errors, or return Error message: "ClassCastException," "NoSuchMethodError," or "Incompatible versions."
- **Possible Causes:** - Different microservices using conflicting versions of the same dependency. Inconsistent dependency management or resolution.
- **Troubleshooting Steps:**
  1. Check the microservice's dependencies and their versions in the project's build configuration file (e.g., pom.xml for Maven).
  2. Identify any conflicting dependencies with different versions.
  3. Resolve the dependency conflict by aligning the versions or excluding conflicting dependencies.
  4. Use a dependency management tool (e.g., Maven's Dependency Management) to manage and resolve conflicts automatically.
  5. Rebuild and restart the microservice to ensure the updated dependencies are used.

## Issue: Service Discovery Failure
- **Symptoms:** Microservice fails to register or discover other services in the environment or return Error message: "Service not found" or "Connection timeout."
- **Possible Causes:** Different microservices using conflicting versions of the same dependency.
- **Troubleshooting Steps:**
  1. Check the service discovery configuration in the microservice's configuration file.
  2. Verify the service discovery server is running and accessible.
  3. Ensure the microservice is registering with the correct service name and network location.
  4. Verify that the service discovery server has up-to-date information about available services.
  5. Check network connectivity and firewall rules to ensure the microservice can communicate with the service discovery server.

## Issue: Performance Degradation
- **Symptoms:** Microservice responds slowly or experiences high latency, or an increased response time or timeouts during high load 
- **Possible Causes:** Inefficient algorithms or code implementation. Excessive database queries or resource-intensive operations Insufficient hardware resources allocated to the microservice. Bottlenecks in network communication or external services.
- **Troubleshooting Steps:**
  1. Monitor system resource usage (CPU, memory, disk) to identify resource bottlenecks.
  2. Analyze the microservice's logs and metrics to identify any performance-related issues.
  3. Check database queries and ensure they are optimized (proper indexing, query tuning).
  4. Review the microservice's code and algorithms for any inefficiencies or performance bottlenecks.
  5. Consider horizontal scaling by deploying multiple instances of the microservice or using load balancing techniques.

## Issue: Security Vulnerabilities
- **Symptoms:** Microservice is vulnerable to security threats or attacks. Security scan reports indicate vulnerabilities in the microservice.
- **Possible Causes:** Out of date Dependency Version
- **Troubleshooting Steps:**
  1. Perform security assessments and vulnerability scans on the microservice.
  2. Update dependencies and libraries to their latest secure versions.
  3. Implement secure coding practices and follow security best practices (input validation, authentication, authorization).
  4. Apply security patches and updates to the underlying infrastructure and frameworks.
  5. Regularly monitor and update security configurations to address new threats and vulnerabilities.

## Issue: Database connection or data access errors
- **Symptoms:** The microservice encounters errors related to database connections or data access.
- **Possible Causes:** Database connection or data access errors can be caused by incorrect database configuration, network issues, or incorrect query execution.
- **Troubleshooting Steps:**
  1. Verify that the database server is running and accessible.
  2. Double-check the database configuration (e.g., connection URL, credentials) in the microservice's configuration files.
  3. Ensure that the microservice has necessary privileges and permissions to access the database.
  4. Test the database connection using a database client or command-line tool to validate the connectivity.
  5. Review the SQL queries or database access code for any syntax errors or incorrect usage.
  6. Check if there are any network or firewall restrictions that may prevent the microservice from accessing the database server.
  7. If the issue persists, gather relevant error messages or stack traces and seek assistance from the project team or community.
  8. Review the logs and error messages to identify any specific issues or exceptions thrown during startup.
  9. Search the project's issue tracker or community forums for similar problems and potential solutions.

## Issue:  MySQL Workbench setup errors
- **Symptoms:** Cannot establish a connection to the MySQL server.
- **Possible Causes:** Incorrect MySQL server hostname or IP address, incorrect MySQL server port number, invalid MySQL username or password, firewall or network configuration blocking the connection, or MySQL server not running or not accessible.
- **Troubleshooting Steps:**
  1. Double-check the MySQL server hostname or IP address you provided in the connection settings.
  2. Verify that the MySQL server port number is correct (usually `3306` by default).
  3. Ensure that the MySQL username and password are correct.
  4. Check your firewall or network configuration to ensure that the MySQL server port is not blocked.
  5. Confirm that the MySQL server is running and accessible from your machine.

## Issue:  MySQL Workbench SSH connection failed
- **Symptoms:** No connection or connection fails.
- **Possible Causes:** Incorrect SSH hostname, username, or password, SSH server not running or not accessible, or invalid SSH key or passphrase.
- **Troubleshooting Steps:**
  1. Verify the SSH hostname, username, and password provided in the connection settings.
  2. Ensure that the SSH server is running and accessible.
  3. If you're using SSH key authentication, make sure you have provided the correct key and passphrase.
  4. Check your firewall or network configuration to ensure that the SSH port is not blocked.

## Issue:  MySQL Workbench connection timeout or slow connection
- **Symptoms:** Connection timeout or slow connection.
- **Possible Causes:** Slow network connection, high server load or resource constraints, incorrect connection settings.
- **Troubleshooting Steps:**
  1. Check your network connection and ensure that you have a stable and fast internet connection.
  2. If the server load is high, consider optimizing the server's resources or upgrading to a higher capacity server.
  3. Review the connection settings and ensure that they are correctly configured.

## Issue:  MySQL Workbench access denied error
- **Symptoms:** Connected but no acces.
- **Possible Causes:** Insufficient privileges for the MySQL user, or Incorrect MySQL username or password.
- **Troubleshooting Steps:**
  1. Verify that the MySQL user has sufficient privileges to access the database.
  2. Double-check the MySQL username and password provided in the connection settings.

## Issue:  Zipkin UI is not accessible
- **Symptoms:** Unable to access the Zipkin user interface in the browser. Error messages or timeouts when trying to access the Zipkin UI.
- **Possible Causes:** Zipkin server is not running or not accessible. Incorrect configuration settings for the Zipkin server or client.
- **Troubleshooting Steps:**
  1. Ensure that the Zipkin server is running and accessible.
  2. Verify the network connectivity between the client and the Zipkin server.
  3. Check the Zipkin server logs for any error messages or startup issues.
  4. Verify the correct configuration settings for the Zipkin server and client, including the correct host and port.
  
## Issue:  Traces are not appearing in Zipkin
- **Symptoms:** No traces or spans are displayed in the Zipkin UI. Missing or incomplete tracing information.
- **Possible Causes:** Tracing instrumentation is not correctly implemented in the application. Incorrect configuration settings for the tracing libraries or Zipkin integration.
- **Troubleshooting Steps:**
  1. Ensure that the application is correctly instrumented for tracing. Check the documentation and examples for the specific programming language or framework being used.
  2. Verify the configuration settings for the tracing libraries and the Zipkin integration. Ensure that the correct Zipkin server URL is specified.
  3. Check the application logs for any error messages related to tracing or Zipkin integration.
  4. If using an intermediary component (e.g., message broker, proxy), ensure that it is correctly configured to propagate tracing headers.

## Issue:  High latency or slow performance in tracing
- **Symptoms:** Tracing adds significant overhead and affects application performance. Increased latency or response times in the traced requests.
- **Possible Causes:** Inefficient tracing instrumentation or configuration. Heavy load or resource constraints on the Zipkin server.
- **Troubleshooting Steps:**
  1. Review the tracing instrumentation in the application. Ensure that only necessary components or operations are traced to minimize overhead.
  2. Adjust the sampling rate or sampling strategy for tracing to reduce the volume of data collected.
  3. Optimize the Zipkin server configuration, such as increasing memory or adjusting thread pool settings, to handle higher loads.
  4. Consider scaling the Zipkin infrastructure horizontally by deploying multiple Zipkin server instances behind a load balancer.

## Conclusion

This troubleshooting guide provides an overview of common issues, symptoms, causes, and troubleshooting steps for working with the microservices and tools. It aims to help you diagnose and resolve issues related to the project.

If you continue to experience persistent issues or encounter different problems during the setup process, please refer to the Microservices and MySQL Workbench documentation or seek assistance from your project team.

If you need further assistance, please contact the project team at [email](oluwajobabello@gmail.com)

If you encounter any issues that are not covered here or need further assistance, please contact the project team at [Secret Escapes](https://www.secretescapes.com)

# CI/CD
This project includes a continuous integration and delivery (CI/CD) pipeline using GitHub Actions. The pipeline is defined in the .github/workflows/ci-cd.yaml file and consists of the following jobs:
>
> The **Lint Code Base:** job runs the Super-Linter to check for linting errors across all files in the repository.  
>
> The **CI/CD Pipeline:** job builds, check for build errors, and ensure they ready to be deployed into production. 
>
> The **Snyk Security** checks for dependencies vulnerabities.
>
These jobs are triggered automatically on every push or pull request to the main branch. They are run on an ubuntu-latest runner, and they each have their own set of steps to execute.  

You can customize this configuration file to fit your specific needs, including adding or removing jobs and modifying the steps within each job.

# Code Structure

- se-full-stack-takehome-challenge

  - backend-application
    - discovery-service
      - .mvn
      - src
        - main
          - java
            - com.secretescapes.discoveryservice
              - DiscoveryServiceApplication.java
          - resources
            - application.properties
            - application-docker.properties        
        - test
          - java
            - com.secretescapes.discoveryservice
              - DiscoveryServiceApplicationTests.java
      - target
      - .gitignore
      - Dockerfile
      - pom.xml          

    - cloud-gateway-service
      - .mvn
      - src
        - main
          - java
            - com.secretescapes.cloudgatewayservice
              - CloudGatewayServiceApplication.java
          - resources
            - application.properties
            - application-docker.properties        
        - test
          - java
            - com.secretescapes.cloudgatewayservice
              - CloudGatewayServiceApplicationTests.java
      - target
      - .gitignore
      - Dockerfile
      - pom.xml

    - favourite-service
      - .mvn
      - src
        - main
          - java
            - com.secretescapes.favouriteservice
              - controller
              - model
              - repository
              - service
              - FavouriteServiceApplication.java
          - resources
            - application.properties
            - application-docker.properties
        - test
          - java
            - com.secretescapes.favouriteservice
              - FavouriteServiceApplicationTests.java
      - target
      - .gitignore
      - Dockerfile
      - pom.xml

    - docker-compose.yml

  - frontend-application
    - node_modules
    - public
    - src
      - api
      - components
        - Buttons
        - Favourite
        - LoadingSpinner
        - LoginButton
        - SaleCard
        - SearchForm
        - index.ts
      - context
      - layout
      - pages
        - FavouritePage
        - Home
        - SaleDetails
        - SearchResults
        - index.ts
      - App.tsx 
      - index.css
      - index.tsx
      - react-app-env.d.ts
      - setupTests.ts
    - .env
    - package.json
    - tsconfig.json
    - yarn.lock
    - .gitignore
    - README.md

>
> **se-full-stack-takehome-challenge/:** Project folder. 
> 
> **backend-application/:** Contains all source code of the application.
>
> **src/:** Contains all frontend source code of the application.  
>
