package com.local.ms_notification.infrastructure.adapter.in.rest.controller.response;

import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class NotificationResponse {
    private Long id;
    private String recipient;
    private String message;
    private String NotificationTypeEnum;
    private LocalDateTime sentAt;
    private NotificationStatusEnum status;
}
