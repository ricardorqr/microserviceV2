package com.microservice.notification.controller;

import com.microservice.notification.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.clients.notification.NotificationRequest;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService service;

    @PostMapping
    @Operation(summary = "Automatically send a notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New Notification: {}", notificationRequest);
        service.sendNotification(notificationRequest);
    }

}
