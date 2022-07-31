# Microservice V2

Microservice:

- [API Gateway](api-gateway/README.md)
- Config Server
- Service Registry:
    - [Eureka Server](eureka-server/README.md)
- Circuit Breaker:
    - Kafka
    - RabbitMQ (Docker)
        - http://localhost:15672
- Services:
    - [Fraud](service-fraud/README.md)
    - [Customer](service-customer/README.md)
    - [Notification](service-notification/README.md)
- Tracing
    - Zipkin and Spring Sleuth (Docker)
        - http://localhost:9411
- [OpenFeign](clients/README.md)

![Microservice V2](files/MicroserviceV2.png)

# Configuration

1 - You need to push all service images to Dockerhub. Please, use the command below.

```shell
<microserviceV2>$ mvn clean package -P docker-build-image
```

2 - You might need to pull the latest images. Please, use the command below.

```shell
<microserviceV2>$ docker-compose pull
```

3 - You do not need to locally run the application through IntelliJ. Docker compose file already have all the service images. Go to the next section and do `docker compose up`.

# Running the application

1. Terminal run `<microserviceV2>$ docker compose up`
3. Open Postman:
    - Do a POST request <localhost:8081/customers/>
    - JSON

```json
{
  "firstName": "Ricardo",
  "lastName": "Ribeiro",
  "email": "ricardo@gmail.com"
}
```

# Links:
- Eureka Server: http://localhost:8761/
- Zipkin: http://localhost:9411/
- Rabbit MQ: http://localhost:15672/
    - Login: guest
    - Password: guest
- H2
    - Customers
        - Link: http://localhost:8081/customers/h2
        - Login: sa
        - Password: password
        - URL: jdbc:h2:mem:customers
    - Fraud
      - Link: http://localhost:8082/fraud/h2
      - Login: sa
      - Password: password
      - URL: jdbc:h2:mem:fraud
    - Notification
        - Link: http://localhost:8083/notification/h2
        - Login: sa
        - Password: password
        - URL: jdbc:h2:mem:notification
- Swagger
  - http://localhost:8081/customers/swagger
  - http://localhost:8082/fraud/swagger
  - http://localhost:8083/notification/swagger