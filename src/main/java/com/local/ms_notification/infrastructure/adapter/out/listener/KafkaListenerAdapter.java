package com.local.ms_notification.infrastructure.adapter.out.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.local.ms_notification.application.port.out.MailSenderOutPutPort;
import com.local.ms_notification.application.port.out.NotificationOutputPort;
import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import com.local.ms_notification.domain.enums.NotificationTypeEnum;
import com.local.ms_notification.domain.model.Notification;
import com.local.ms_notification.infrastructure.adapter.out.listener.entity.Order;
import com.local.ms_notification.infrastructure.adapter.out.listener.entity.OrderType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class KafkaListenerAdapter {

    private final MailSenderOutPutPort mailSenderOutPutPort;
    private final NotificationOutputPort notificationOutputPort;
    @Value("${mail.send.notification.email}")
    private String sentAt;

    @KafkaListener(topics = "${spring.kafka.topic.order-topic}")
    public Order readTopic(String message) {

        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        try {
            Order order = objectMapper.readValue(message, Order.class);
            if(order.getOrderType()== OrderType.ENCARGO){
                mailSenderOutPutPort.sendEmail(order);
                Notification notification= Notification.builder()
                        .type(NotificationTypeEnum.EMAIL)
                        .orderId(order.getId())
                        .recipient(sentAt)
                        .status(NotificationStatusEnum.ENVIADA)
                        .sentAt(LocalDateTime.now())
                        .build();
                notificationOutputPort.save(notification);
            }
            log.info(order.toString());
            return order;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error al leer del json");
        }catch (Exception e){
            throw new RuntimeException("error al leer del topico");
        }

    }
}
