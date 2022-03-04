package com.microservice.customer.service;

import com.microservice.clients.fraud.FraudCheckResponse;
import com.microservice.clients.fraud.FraudClient;
import com.microservice.clients.notification.NotificationClient;
import com.microservice.clients.notification.NotificationRequest;
import com.microservice.customer.dto.CustomerRequest;
import com.microservice.customer.model.Customer;
import com.microservice.customer.repository.CustomerRepository;
import com.microservice.rabbitmq.RabbitMessageQueueProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    private final RabbitMessageQueueProducer producer;

    public void saveCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                                    .firstName(customerRequest.getFirstName())
                                    .lastName(customerRequest.getLastName())
                                    .email(customerRequest.getEmail())
                                    .build();
        repository.saveAndFlush(customer);

        // The code below will be replaced to fraudClient.isFraudster
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://service-fraud/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        // Client service
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }

        NotificationRequest notificationRequest = NotificationRequest.builder()
                                                                     .toCustomerId(customer.getId())
                                                                     .toCustomerName(customer.getEmail())
                                                                     .message(String.format("Hi %s, How are you?", customer.getFirstName()))
                                                                     .build();

        // Notification service
        // No need to send notification though Notification Service. Now, it is sending the notification (message)
        // to the message queue
//        notificationClient.sendNotification(notificationRequest);
        producer.publish(notificationRequest, "internal.exchange", "internal.notification.routing-key");
    }

}
