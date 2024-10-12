package com.local.ms_notification.infrastructure.adapter.in.rest.controller;

import com.local.ms_notification.application.port.in.FindNotificationUseCase;
import com.local.ms_notification.application.port.in.SaveNotificationUseCase;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.mapper.NotificationRestMapper;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.port.NotificationAPIPort;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.request.NotificationRequest;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.response.GenericResponse;
import com.local.ms_notification.infrastructure.adapter.in.rest.controller.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/notifications")
public class NotificationController implements NotificationAPIPort {

    private final NotificationRestMapper notificationRestMapper;
    private final FindNotificationUseCase findNotificationUseCase;
    private final SaveNotificationUseCase saveNotificationUseCase;


    @Override
    public GenericResponse getNotifications(Pageable pageable) {
        Page<NotificationResponse> page = findNotificationUseCase.findNotifications(pageable)
                .map(notificationRestMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(notificationRestMapper.toPageResponse(page));
        return genericResponse;
    }

    @Override
    public GenericResponse queryNotifications(NotificationRequest notificationRequest, Pageable pageable) {
        Page<NotificationResponse> page = findNotificationUseCase.findNotifications(pageable, notificationRestMapper.toModel(notificationRequest))
                .map(notificationRestMapper::toResponse);
        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(page.getContent());
        genericResponse.setPageResponse(notificationRestMapper.toPageResponse(page));
        return genericResponse;
    }

    @Override
    public GenericResponse queryNotifications(Long id) {
        NotificationResponse notificationResponse =
                notificationRestMapper.toResponse(findNotificationUseCase.findNotificationById(id));

        GenericResponse genericResponse = GenericResponse.success();
        genericResponse.setData(notificationResponse);

        return genericResponse;
    }

    @Override
    public GenericResponse createNotification(NotificationRequest notification) {

        NotificationResponse notificationResponse = notificationRestMapper.toResponse(
                saveNotificationUseCase.save(notificationRestMapper.toModel(notification))
        );
        log.info("notification created {}", notificationResponse.toString());
        return GenericResponse.success();
    }

    @Override
    public GenericResponse updateNotification(NotificationRequest notification) {
        NotificationResponse notificationResponse = notificationRestMapper.toResponse(
                saveNotificationUseCase.update(notificationRestMapper.toModel(notification))
        );
        log.info("notification updated {}", notificationResponse.toString());
        return GenericResponse.success();
    }

}
