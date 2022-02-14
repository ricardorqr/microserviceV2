package com.microservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
