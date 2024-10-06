package com.local.ms_notification.infrastructure.adapter.in.rest.controller.request;

import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class NotificationRequest {

    private Long id;
    @NotNull
    private String recipient;
    @NotNull
    private String message;
    @NotNull
    private String NotificationTypeEnum;
    private LocalDateTime sentAt;
    private NotificationStatusEnum status;
}
