package com.hsnam.message.publisher.receiver;

import com.hsnam.message.publisher.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Receiver {
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "hsnam.key"),
//            exchange = @Exchange(value = "amq.direct", type = "direct", durable = "true"), //
//            key = "hsnam.key"))
//    public void handleDirectExchange(Person in) {
//        log.info("handleDirectExchange="+in.toString());
//    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "foo.hsnam.task"),
            exchange = @Exchange(value = "amq.topic", type = "topic", durable = "true"), //
            key = "foo.hsnam.task"))
    public void handleTopicCase1(Person in) {
        log.info("key = innopam.hsnam.task");
        log.info("handleTopicCase1="+in.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "foo.hsnam.task"),
            exchange = @Exchange(value = "amq.topic", type = "topic", durable = "true"), //
            key = "foo.hsnam.task"))
    public void handleTopicCase2(Person in) {
        log.info("key = foo.hsnam.task");
        log.info("handleTopicCase2="+in.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "foo.hsnam.task"),
            exchange = @Exchange(value = "amq.topic", type = "topic", durable = "true"), //
            key = "foo.hsnam.task"))
    public void handleTopicCase3(Person in) {
        log.info("key = foo.hsnam.task");
        log.info("handleTopicCase3="+in.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout.1"),
            exchange = @Exchange(value = "amq.fanout", type = "fanout", durable = "true"), //
            key = "fanout.1"))
    public void handleTopic1FanoutExchaneg(Person in) {
        log.info("handleTopic1FanoutExchaneg="+in.toString());
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout.2"),
            exchange = @Exchange(value = "amq.fanout", type = "fanout", durable = "true"), //
            key = "fanout.2"))
    public void handleTopic2FanoutExchaneg(Person in) {
        log.info("handleTopic2FanoutExchaneg="+in.toString());
    }
}
