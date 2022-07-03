package com.ayush.productservice.producer;

public interface OrderProducer {
    void produceOrder(String topic,String json);
}
