package com.microservice.notification.service.service;

import java.time.LocalDateTime;

import com.microservice.notification.service.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import com.microservice.clients.notification.NotificationRequest;
import com.microservice.notification.service.model.Notification;

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
