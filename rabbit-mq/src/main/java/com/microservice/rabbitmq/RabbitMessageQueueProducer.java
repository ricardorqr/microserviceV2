package com.microservice.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@AllArgsConstructor
@Component
public class RabbitMessageQueueProducer {

    private final AmqpTemplate amqpTemplate;

    public void publish(Object payLoad, String exchange, String routingKey) {
        log.info("Publishing to {} using routingKey {}. Payload: {}", exchange, routingKey, payLoad);
        amqpTemplate.convertAndSend(exchange, routingKey, payLoad);
        log.info("Published to {} using routingKey {}. Payload: {}", exchange, routingKey, payLoad);
    }

}


