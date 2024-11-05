package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = "myqueue")
    public void listen(String in) {
        log.info("Received message: {}", in);
    }

//    @RabbitListener(queues = "queue1")
//    public void listen1(String message) {
//        log.info("Received message 1: {}", message);
//    }
//
//    @RabbitListener(queues = "queue2")
//    public void listen2(String message) {
//        log.info("Received message 2: {}", message);
//    }
//
//    @RabbitListener(queues = "queue3")
//    public void listen3(String message) {
//        log.info("Received message 3: {}", message);
//    }
}
