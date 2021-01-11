package com.hsnam.message.publisher.service;

import com.hsnam.message.publisher.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailMsgSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    public void sendEmail(String routingKey, Email email){
        log.info("convertAndSend="+routingKey);
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, email);
    }
}
