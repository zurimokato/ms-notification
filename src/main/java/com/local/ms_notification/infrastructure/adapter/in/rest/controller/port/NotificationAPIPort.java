package com.local.ms_notification.infrastructure.adapter.in.rest.controller.port;

import com.local.ms_notification.infrastructure.adapter.in.rest.controller.request.NotificationRequest;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


public interface NotificationAPIPort {

    @GetMapping
    GenericResponse getNotifications(Pageable pageable);

    @GetMapping("/query")
    GenericResponse queryNotifications(@RequestParam NotificationRequest notificationRequest,Pageable pageable);

    @GetMapping("/{id}")
    GenericResponse queryNotifications(@PathVariable("id") Long id);

    @PostMapping
    GenericResponse createNotification(@RequestBody NotificationRequest notification);

    @PutMapping
    GenericResponse updateNotification(@RequestBody NotificationRequest notification);

}
