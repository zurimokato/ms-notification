package com.local.ms_notification.domain.model;

import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import com.local.ms_notification.domain.enums.NotificationTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class Notification {
    private Long id;
    private String recipient;
    private String orderId;
    private NotificationTypeEnum type;
    private LocalDateTime sentAt;
    private NotificationStatusEnum status;
}
