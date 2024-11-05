package com.example.demo.controller;


import com.example.demo.service.QueueService;
import com.example.demo.service.QueueSize;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.random.RandomGenerator;
import java.util.stream.IntStream;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final QueueService queueService;
    private final RabbitTemplate rabbitTemplate;


    @GetMapping("/")
    public QueueSize index() {

        return queueService.monitorQueue("myqueue");
    }

    @PostMapping("/add/{priority}")
    public String add(@PathVariable @Min(1) @Max(5) Integer priority) {

        generateAndSendQueueMessageHelloUUID(priority);
        return "OK";
    }

    @PostMapping("/addm")
    public String addMillion() {
        IntStream.range(0, 1_000_000).forEach(
                x -> {
                    int priority = RandomGenerator.getDefault().nextInt(1, 5);
                    generateAndSendQueueMessageHelloUUID(priority);
                }
        );
        return "OK";
    }

    private void generateAndSendQueueMessageHelloUUID(Integer priority) {
        rabbitTemplate.convertAndSend("myqueue", "hello" + UUID.randomUUID(), message -> {
            message.getMessageProperties().setCorrelationId(UUID.randomUUID().toString());
            message.getMessageProperties().setPriority(priority);
            return message;
        });
    }
}
