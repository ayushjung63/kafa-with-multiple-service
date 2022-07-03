package com.ayush.orderservice.service.impl;

import com.ayush.orderservice.model.Order;
import com.ayush.orderservice.repo.OrderRepo;
import com.ayush.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    @Override
    public void create(Order order) {
        Order save = orderRepo.save(order);
    }
}
