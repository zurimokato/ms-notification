package com.local.ms_notification.infrastructure.adapter.out.database.mappers;

import com.local.ms_notification.domain.model.Notification;
import com.local.ms_notification.infrastructure.adapter.out.database.entities.NotificationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationEntityMapper {

    Notification toModel(NotificationEntity source);
    NotificationEntity toEntity(Notification source);
}
