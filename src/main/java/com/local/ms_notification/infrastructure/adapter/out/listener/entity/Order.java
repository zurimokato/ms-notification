package com.local.ms_notification.infrastructure.adapter.out.listener.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class Order {
    private String id;
    private LocalDateTime orderDate;
    private Long customerId;
    private String customerDocument;
    private OrderStatus status;
    private PayMethod payMethod;
    private OrderType orderType;
    private List<OrderLine> orderLines;
    private double totalPrice;

}
