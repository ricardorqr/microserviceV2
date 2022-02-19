package com.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.clients.serviceFraud.FraudCheckResponse;
import com.microservice.clients.serviceFraud.FraudClient;
import com.microservice.dto.CustomerRequest;
import com.microservice.model.Customer;
import com.microservice.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

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

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster");
        }
    }

}
