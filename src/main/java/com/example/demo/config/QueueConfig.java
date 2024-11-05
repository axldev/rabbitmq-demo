package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class QueueConfig {


    @Bean
    public Queue myQueue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-max-priority", 10);
        return new Queue("myqueue", true, false, false, args);
    }
//    @Bean
//    public Queue queue1() {
//        return new Queue("queue1");
//    }
//
//    @Bean
//    public Queue queue2() {
//        return new Queue("queue2");
//    }
//
//    @Bean
//    public Queue queue3() {
//        return new Queue("queue3");
//    }
//
//    @Bean
//    public Binding binding1(Queue queue1, TopicExchange exchange) {
//        return BindingBuilder.bind(queue1).to(exchange).with("routing_key_1");
//    }
//
//    @Bean
//    public Binding binding2(Queue queue2, TopicExchange exchange) {
//        return BindingBuilder.bind(queue2).to(exchange).with("routing_key_2");
//    }
//
//    @Bean
//    public Binding binding3(Queue queue3, TopicExchange exchange) {
//        return BindingBuilder.bind(queue3).to(exchange).with("routing_key_3");
//    }
}