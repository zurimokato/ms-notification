package com.local.ms_notification.infrastructure.adapter.in.rest.controller.port;

import com.local.ms_notification.infrastructure.adapter.in.rest.controller.request.NotificationRequest;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface NotificationAPIPort {

    @GetMapping
    ResponseEntity<GenericResponse> getNotifications(Pageable pageable);

    @GetMapping("/query")
    ResponseEntity<GenericResponse> queryNotifications(@RequestParam NotificationRequest notificationRequest,Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> queryNotifications(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<GenericResponse> createNotification(@RequestBody NotificationRequest notification);

    @PutMapping
    ResponseEntity<GenericResponse> updateNotification(@RequestBody NotificationRequest notification);

}
