package com.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.dto.FraudCheckResponse;
import com.microservice.service.FraudService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private FraudService service;

    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("Fraud check request for the customer: {}", customerId);
        return FraudCheckResponse.builder()
                .isFraudster(service.isFraudulentCustomer(customerId))
                .build();
    }

}
