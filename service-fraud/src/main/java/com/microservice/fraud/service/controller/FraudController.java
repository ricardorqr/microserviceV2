package com.microservice.fraud.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.clients.fraud.FraudCheckResponse;
import com.microservice.fraud.service.service.FraudService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudService service;

    @GetMapping("/{customerId}")
    @Operation(summary = "Check if a customer is fraudulent")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("Fraud check request for the customer: {}", customerId);
        return FraudCheckResponse.builder()
                .isFraudster(service.isFraudulentCustomer(customerId))
                .build();
    }

}
