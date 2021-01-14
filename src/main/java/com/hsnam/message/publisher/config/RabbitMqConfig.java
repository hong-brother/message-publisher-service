package com.hsnam.message.publisher.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    private String directName = "amq.direct";
    private String topicName = "amq.topic";
    private String fanout = "amq.fanout";
    private String headers = "amq.headers";

    @Bean
    public DirectExchange
    directExchange() {
        return new DirectExchange(this.directName);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(this.fanout);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(this.topicName);
    }

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(this.headers);
    }

//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange){
//        return BindingBuilder.bind(queue).to(exchange).with(this.topicName);
//    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMandatory(true);
//        rabbitTemplate.setChannelTransacted(true);
//        rabbitTemplate.setReplyTimeout(60000);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
}
