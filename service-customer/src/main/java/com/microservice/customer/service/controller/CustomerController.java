package com.microservice.customer.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.customer.service.dto.CustomerRequest;
import com.microservice.customer.service.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/")
    @Operation(summary = "Insert a new customer")
    public void saveCustomer(@RequestBody CustomerRequest customerRequest) {
        log.info("New customer: {}", customerRequest);
        service.saveCustomer(customerRequest);
    }

}
