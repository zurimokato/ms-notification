package com.local.ms_notification.infrastructure.adapter.out.listener.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderLine {
    private String orderId;
    private String productId;
    private String name;
    private int quantity;
    private double price;
    private double subtotal;
}
