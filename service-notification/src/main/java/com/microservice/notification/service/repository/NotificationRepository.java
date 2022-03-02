package com.microservice.notification.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.notification.service.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {

}
