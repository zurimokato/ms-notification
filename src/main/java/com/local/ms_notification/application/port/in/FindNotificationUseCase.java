package com.local.ms_notification.application.port.in;

import com.local.ms_notification.domain.model.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindNotificationUseCase {
    Notification findNotificationById(Long id);
    Page<Notification> findNotifications(Pageable pageable);
    Page<Notification> findNotifications(Pageable pageable, Notification notification);

}
