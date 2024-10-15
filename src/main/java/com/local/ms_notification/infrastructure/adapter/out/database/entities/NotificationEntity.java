package com.local.ms_notification.infrastructure.adapter.out.database.entities;

import com.local.ms_notification.domain.enums.NotificationStatusEnum;
import com.local.ms_notification.domain.enums.NotificationTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipient;
    @Column(name = "order_id")
    private String orderId;
    @Enumerated(EnumType.STRING)
    private NotificationTypeEnum type;
    @Column(name = "sent_at")
    private LocalDateTime sentAt;
    @Enumerated(EnumType.STRING)
    private NotificationStatusEnum status;
}
