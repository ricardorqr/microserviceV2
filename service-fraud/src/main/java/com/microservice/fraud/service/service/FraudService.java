package com.microservice.fraud.service.service;

import java.time.LocalDateTime;

import com.microservice.fraud.service.model.Fraud;
import com.microservice.fraud.service.repository.FraudRepository;
import org.springframework.stereotype.Service;

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
