package com.ayush.productservice.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderProducerImpl implements OrderProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void produceOrder(String topic, String json) {
        log.info("Publishing Order Detail");
        log.info(json);
        kafkaTemplate.send(topic,json);
    }
}
