package com.local.ms_notification.application.port.in;

import com.local.ms_notification.domain.model.Notification;

public interface SaveNotificationUseCase {
    Notification save(Notification notification);
    Notification update(Notification notification);
}
