package com.hsnam.message.publisher.service;

import com.hsnam.message.publisher.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PublisherService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private TopicExchange topicExchange;

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private HeadersExchange headersExchange;

    public void sendDirectExchange(String routingKey, Person person){
        log.info("RoutingKey = "+ routingKey);
        rabbitTemplate.convertAndSend(directExchange.getName(), routingKey, person);
    }

    public void sendFanoutExchange(Person person){
        log.info("fanout");
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), person);
    }

    public void sendTopicExchange(String routingKey, Person person){
        log.info("RoutingKey = "+ routingKey);
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, person);
    }
}
