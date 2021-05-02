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
## Apache Kafka + Zookeeper
To start the Kafka broker + Zookeeper, use docker-compose
```
docker-compose up -d
```
To test Kafka, use the project "kafka-example" to demonstrate the publishing and consuming messages from Kafka.
```
mvnw spring-boot:run -pl kafka-example
```
To Stop the Kafka broker + Zookeeper,
```
docker stop <container-id>
```

## User service

To start the microservice "user service", run the following command in the root folder.
```
mvnw spring-boot:run -pl ms-user
```
Two public APIs are exposed:

 - http://localhost:8082/members
 - http://localhost:8082/register

## Mail service

To start the microservice "user service", run the following command in the root folder.
```
mvnw spring-boot:run -pl ms-user
```

<!--stackedit_data:
eyJoaXN0b3J5IjpbMjA5MDk4MDQ4OSwtNDQ2MjE0OTUzLC0xOD
k1OTgxNTAxLC0xODM5MDM2NzA0LDU1OTc2MjUwNiwyMTQzOTYx
ODk5LDE4MzMzNDc1MzldfQ==
-->