package com.local.ms_notification.infrastructure.adapter.out.database;

import com.local.ms_notification.application.port.out.NotificationOutputPort;
import com.local.ms_notification.domain.model.Notification;
import com.local.ms_notification.infrastructure.adapter.out.database.entities.NotificationEntity;
import com.local.ms_notification.infrastructure.adapter.out.database.mappers.NotificationEntityMapper;
import com.local.ms_notification.infrastructure.adapter.out.database.repository.NotificationRepository;
import com.local.ms_notification.infrastructure.adapter.out.database.specifications.NotificationSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class NotificationPersistenceAdapter implements NotificationOutputPort {

    private final NotificationRepository notificationRepository;
    private final NotificationEntityMapper notificationEntityMapper;
    @Override
    public Notification getNotificationById(Long id) {
        return notificationEntityMapper.toModel(
                notificationRepository.findById(id)
                        .orElseThrow(()->new RuntimeException("notification not found"))
        );
    }

    @Override
    public Notification save(Notification notification) {
        return notificationEntityMapper.toModel(
                notificationRepository.save(
                        notificationEntityMapper.toEntity(notification)
                )
        );
    }

    @Override
    public Page<Notification> getNotifications(Pageable pageable) {
        return notificationRepository.findAll(pageable)
                .map(notificationEntityMapper::toModel);
    }

    @Override
    public Page<Notification> getNotifications(Pageable pageable, Notification filter) {
        Specification<NotificationEntity> spec = NotificationSpecification.filterByEntity(filter);
        return notificationRepository.findAll(spec,pageable)
                .map(notificationEntityMapper::toModel);
    }
}
