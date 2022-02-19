package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableEurekaClient
@OpenAPIDefinition(
        info = @Info(
                title = "Fraud API",
                version = "1.0",
                contact = @Contact(name = "Ricardo Ribeiro", url = "https://github.com/ricardorqr/microserviceV2", email = "ricardorqr@gmail.com"),
                license = @License(name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0.html")
        )
)
public class FraudApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudApplication.class, args);
    }
}
