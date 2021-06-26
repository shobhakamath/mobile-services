# mobile-services
Application url : https://servicesmobile.herokuapp.com
Search api : https://servicesmobile.herokuapp.com/search


# Tech stack used:
Java 11
Spring Boot 2.5.1
Spring REST API (Spring Web)
Lombok 1.18.20
springdoc-openapi-ui -  OpenAPI 3.0 
Dockerized (Dockerfile is included and used the latest concept called multi-layered image building for optimized build time)
TDD approach using JUnit 5, Mockito, and Spring Boot Test
JaCoCo for code coverage
webclient for http calls

# OpenAPI definition using springdoc-openapi-ui

https://servicesmobile.herokuapp.com/swagger-ui/index.html

# CICD pipeline
Using github actions 
Deploy to Heroku 

# Code Coverage
Jacoco reports

# Logging
 logback.xml

# Eureka server registration
http://myeureka-server.herokuapp.com/


# Steps to build the Docker Image:
Step 1: Enter the project directory,
cd <project_directory>
Step 2: To clean and package the micro-service locally
mvn clean package
Step 3: Build the docker image and store it in a local repository (Dockerfile is there in the root of the directory itself)
docker build . --tag mobile-services
Step 4: Run the micro-service as a container in the docker:
docker run -it -p 8080:8080 mobile-services:latest


# Other details

Config server integration was not done due to limitations on Heroku environments.
Docs added on architecture details