package com.local.ms_notification.infrastructure.adapter.in.rest.controller.response;

import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationResponse {
    private Long id;
    private String recipient;
    private String message;
    private String notificationTypeEnum;
    private LocalDateTime sentAt;
    private NotificationStatusEnum status;
}
