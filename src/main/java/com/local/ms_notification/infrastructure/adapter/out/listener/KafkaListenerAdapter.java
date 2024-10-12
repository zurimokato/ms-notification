package com.local.ms_notification.infrastructure.adapter.out.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.local.ms_notification.infrastructure.adapter.out.listener.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class KafkaListenerAdapter {

    @KafkaListener(topics = "orders")
    public Order readTopic(String message) {

        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        try {
            Order order = objectMapper.readValue(message, Order.class);

            log.info(order.toString());
            return order;
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error al leer del tópico");
        }

    }
}
