package com.ayush.productservice.service.impl;

import com.ayush.productservice.constants.Topic;
import com.ayush.productservice.model.Product;
import com.ayush.productservice.model.User;
import com.ayush.productservice.pojos.OrderPOJO;
import com.ayush.productservice.producer.OrderProducer;
import com.ayush.productservice.repo.ProductRepo;
import com.ayush.productservice.repo.UserRepo;
import com.ayush.productservice.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final UserRepo userRepo;
    private final ObjectMapper objectMapper;
    private final OrderProducer orderProducer;

    public ProductServiceImpl(ProductRepo productRepo, UserRepo userRepo, ObjectMapper objectMapper, OrderProducer orderProducer) {
        this.productRepo = productRepo;
        this.userRepo = userRepo;
        this.objectMapper = objectMapper;
        this.orderProducer = orderProducer;
    }

    @Override
    public Long create(Product product) {
        Product data = productRepo.save(product);
        return data.getId();
    }

    @Override
    public Long orderProduct(OrderPOJO orderPOJO) throws JsonProcessingException {
        Product product = productRepo.findById(orderPOJO.getProductId()).get();
        User user = userRepo.findById(orderPOJO.getUserId()).get();
        OrderPOJO order = OrderPOJO.builder()
                .productId(product.getId())
                .userId(user.getId())
                .orderBy(user.getFullName())
                .price(product.getPrice())
                .productName(product.getName())
                .build();
        String jsonData = objectMapper.writeValueAsString(order);
        orderProducer.produceOrder(Topic.ORDER_TOPIC,jsonData);
        return 1L;
    }
}
