package com.local.ms_notification.infrastructure.adapter.in.rest.controller.mapper;

import com.local.ms_notification.domain.model.Notification;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.request.NotificationRequest;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.response.NotificationResponse;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.response.PageResponse;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Mapper(componentModel = "spring")
public interface NotificationRestMapper {

    Notification toModel(NotificationRequest source);

    NotificationResponse toResponse(Notification source);
    PageResponse toPageResponse(Page<NotificationResponse> source);
}
