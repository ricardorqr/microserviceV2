package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.model.Fraud;

@Repository
public interface FraudRepository extends JpaRepository<Fraud, Integer> {

}
