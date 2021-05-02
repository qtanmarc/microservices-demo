# Microservices-demo

The demo project is to build a registration system that will send a confirmation mail after new user is registered.


## Components
Following components will be part of the system:

 1. **Service registry (Eureka)**: where all services will register themselves
 
 2. **Config server (Spring Cloud config)**: where all services will take their configuration from. 
 -  Config server will keep configuration files in GIT repository
 
 3. **User service**: using this one the new users will register
 - On  every new registration, the User Service will send a message “USER_REGISTERED” to **the message broker (Kafka)**
 
 4. **Email Service**
 - On “USER_REGISTERED” message received the Email Service will send a confirmation email to the new user.
  
## Start the service registry (Eureka)
To run the Eureka service with Maven, run the following command in the root folder.
```
mvnw spring-boot:run -pl eureka-server
```
Check Eureka running on:
```
http://localhost:8761/
```

## Start the Config Server (Spring Cloud Config)
To start the config server, run the following command in the root folder.
```
mvnw spring-boot:run -pl config-server
```
Check Config server will return some of the configurations we have in ms-config-properties folder:
```
http://localhost:8888/ms-service/dev
```
There are two modes to fetch the configs: either **native** or **git**
**native** that we can change in *application.yml.*

## Apache Kafka + Zookeeper
To start the Kafka broker + Zookeeper, use docker-compose
```
docker-compose up -d
```
To test Kafka, use the project "kafka-example" to demonstrate the publishing and consuming messages from Kafka.
```
mvnw spring-boot:run -pl kafka-example
```
To Stop the Kafka  the ro oer,
``k spinr-id
```

## Ue 
To start the  run the following command in the root folder.
```
mvnw spring-boot:run -pl ms-
```
APIs are exposed:

 - http://localhost:8082/members
 - http://localhost:8082/register

## Mail service

To start the microservice "mail service", run the following command in the root folder.
```
mvnw spring-boot:run -pl ms-mail
```

## Gateway (Zuul)
To start the gateway Zuulmicroservice "mail service", run the following command in the root folder. Any request to **8765:/api/user** will be now redirected to the ms-user micro-service
```
mvnw spring-boot:run -pl ms-gatewaymail
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbOTI1MzU4NTMwLDk5MDMwOTgyNSwtMTkxMj
IyNzM5OSwtNDQ2MjE0OTUzLC0xODk1OTgxNTAxLC0xODM5MDM2
NzA0LDU1OTc2MjUwNiwyMTQzOTYxODk5LC0xOTQwNTI0NTAzLD
E4MzMzNDc1MzksOTA3NTM0NjM3LC04OTMxNzM2OTAsLTIxNzA4
MDg3MCwtMzMyNDU1MzYzXX0=
-->