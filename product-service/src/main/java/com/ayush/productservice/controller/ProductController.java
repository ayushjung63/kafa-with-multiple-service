package com.ayush.productservice.controller;

import com.ayush.productservice.pojos.OrderPOJO;
import com.ayush.productservice.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public String orderProduct(@RequestBody OrderPOJO orderPOJO){
        try {
            Long orderProduct = productService.orderProduct(orderPOJO);
            return "Product Ordered and Published to Order Service";
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error";
        }
    }
}
