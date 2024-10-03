package com.local.ms_notification.application.port.out;

import com.local.ms_notification.domain.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationOutputPort {
    Notification getNotificationById(Long id);
    Notification save(Notification notification);
    Page<Notification> getNotifications(Pageable pageable);
    Page<Notification> getNotifications(Pageable pageable, Notification filter);
}
