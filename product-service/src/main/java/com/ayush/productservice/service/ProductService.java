package com.ayush.productservice.service;

import com.ayush.productservice.model.Product;
import com.ayush.productservice.pojos.OrderPOJO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ProductService {

    Long create(Product product);

    Long orderProduct(OrderPOJO orderPOJO) throws JsonProcessingException;
}
