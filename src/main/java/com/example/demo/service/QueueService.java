package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@RequiredArgsConstructor
public class QueueService {
    private final RabbitTemplate rabbitTemplate;
    private final AmqpAdmin amqpAdmin;

    public QueueSize monitorQueue(String queueName) {

        Properties queueProperties = amqpAdmin.getQueueProperties(queueName);
        return new QueueSize(
                queueProperties,
                rabbitTemplate.getUnconfirmedCount()
        );

    }



}
