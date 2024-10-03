package com.local.ms_notification.domain.services;

import com.local.ms_notification.application.port.in.FindNotificationUseCase;
import com.local.ms_notification.application.port.in.SaveNotificationUseCase;
import com.local.ms_notification.application.port.out.NotificationOutputPort;
import com.local.ms_notification.domain.model.Notification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService implements FindNotificationUseCase, SaveNotificationUseCase {
    private final NotificationOutputPort notificationOutputPort;

    @Override
    public Notification findNotificationById(Long id) {
        return notificationOutputPort.getNotificationById(id);
    }

    @Override
    public Page<Notification> findNotifications(Pageable pageable) {
        return notificationOutputPort.getNotifications(pageable);
    }

    @Override
    public Page<Notification> findNotifications(Pageable pageable, Notification notification) {
        return notificationOutputPort.getNotifications(pageable, notification);
    }

    @Override
    public Notification save(Notification notification) {
        return notificationOutputPort.save(notification);
    }

    @Override
    public Notification update(Notification notification) {
        Notification old = notificationOutputPort.getNotificationById(notification.getId());

        return notificationOutputPort.save(notification);
    }
}
