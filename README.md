# java-spring3-microservice
*Java archetype oriented to Microservices.*

Clean architecture, Java 21, Spring Boot 3, distributed tracing, log centralization and Keycloak.

## Dependencies
Java 21, Docker, Maven

## Features
- Clean Architecture
    - Exception Controller
    - Custom Messages and Exceptions
    - Pagination and Ordering
- Java 21
    - OpenJDK or GraalVM integration
- Spring Boot 3
    - Spring Web
    - Spring Data JPA
    - Spring OAuth2 Resource Server
    - Spring Security
    - Spring Devtools
    - Spring Actuator
- Keycloak as Auth Server
- Distributed tracing
    - OpenTelemetry, Micrometer and Jaeger
- Log Centralization
    - Logstash, ElasticSearch and Kibana
- Swagger
    - OpenApi
- Auditory
    - JPA auditing
- Database
    - Postgres for the app
    - H2 for Test
    - Schema generation (schema.sql)

## Files
- [Docker files](https://github.com/javiorfo/java-spring3-microservice/tree/master/docker)
- [Kubernetes files](https://github.com/javiorfo/java-spring3-microservice/tree/master/k8s)
- [Ship files](https://github.com/javiorfo/java-spring3-microservice/tree/master/ships)
    - For those using Neovim and [this plugin](https://github.com/javiorfo/nvim-ship)

## Usage
- Create the containers executing `./containers.sh` 
- Start the application with the command `mvn spring-boot:run -Pdev`
- To delete all the containers: `./containers.sh d`

## MongoDB instead of Postgres
- [MongoDB repo](https://github.com/javiorfo/java-spring3-microservice-mongo) contains version with MongoDB
---

### Donate
- **Bitcoin** [(QR)](https://raw.githubusercontent.com/javiorfo/img/master/crypto/bitcoin.png)  `1GqdJ63RDPE4eJKujHi166FAyigvHu5R7v`
- [Paypal](https://www.paypal.com/donate/?hosted_button_id=FA7SGLSCT2H8G)
