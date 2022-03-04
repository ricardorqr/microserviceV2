package com.microservice.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.fraud.model.Fraud;

@Repository
public interface FraudRepository extends JpaRepository<Fraud, Integer> {

}
