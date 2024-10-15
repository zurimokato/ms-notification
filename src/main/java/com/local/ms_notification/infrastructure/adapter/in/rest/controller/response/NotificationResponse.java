package com.local.ms_notification.infrastructure.adapter.in.rest.controller.response;

import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import com.local.ms_notification.domain.enums.NotificationTypeEnum;
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
    private String orderId;
    private NotificationTypeEnum type;
    private LocalDateTime sentAt;
    private NotificationStatusEnum status;
}
