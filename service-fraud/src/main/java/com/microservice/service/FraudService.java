package com.microservice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.microservice.model.Fraud;
import com.microservice.repository.FraudRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudService {

    private FraudRepository repository;

    public boolean isFraudulentCustomer(Integer customerId) {
        Fraud fraud = Fraud.builder()
                .customerId(customerId)
                .isFraudster(false)
                .date(LocalDateTime.now())
                .build();

        repository.save(fraud);
        return false;
    }

}
