package com.example.demo.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

//    public void sendMessage(String message) {
//        rabbitTemplate.convertAndSend("my_exchange", "routing_key_1", message);
//    }
}
