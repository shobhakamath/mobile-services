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

Step 3: Build the docker image and store it in a local repository 

docker build . --tag mobile-services

Step 4: Run the micro-service as a container in the docker:

docker run -it -p 8080:8080 mobile-services:latest


# Other details

Config server integration was not done due to limitations on Heroku environments.


https://github.com/shobhakamath/mobile-services

A sample request to test the application deployed in Heroku is given 

https://servicesmobile.herokuapp.com/search?sim=esim

The application can be tested using the Swagger UI : 

https://servicesmobile.herokuapp.com/swagger-ui/index.html?configUrl=/mobile-services-doc/swagger-config

The deployment CICD pipeline is done using Github actions:

https://github.com/shobhakamath/mobile-services/actions

The documentation for the assignment can be found in the README file and the docs folder.

https://github.com/shobhakamath/mobile-services/tree/main/docs


