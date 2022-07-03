package com.ayush.orderservice.receiver;

import com.ayush.orderservice.constants.Topic;
import com.ayush.orderservice.model.Order;
import com.ayush.orderservice.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderReceiverListener {
    private final OrderService  orderService;
    private final ObjectMapper objectMapper;

    public OrderReceiverListener(OrderService orderService, ObjectMapper objectMapper) {
        this.orderService = orderService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = {Topic.ORDER_TOPIC})
    public void receiverOrder(@Payload String jsonOrder) throws JsonProcessingException {
        log.info("Receiving Order");
        log.info(jsonOrder);
        Order order = objectMapper.readValue(jsonOrder, Order.class);
        orderService.create(order);
    }
}
