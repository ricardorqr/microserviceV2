package com.microservice.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.microservice.clients.notification.NotificationRequest;
import com.microservice.model.Notification;
import com.microservice.repository.NotificationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerId(notificationRequest.getToCustomerId())
                .toCustomerEmail(notificationRequest.getToCustomerName())
                .sender("Ricardo")
                .message(notificationRequest.getMessage())
                .date(LocalDateTime.now())
                .build();

        repository.save(notification);
    }

}
