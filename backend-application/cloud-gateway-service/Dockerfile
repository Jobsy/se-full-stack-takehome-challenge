FROM openjdk:21-ea-22-jdk-slim

COPY target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]