package com.hsnam.message.publisher.web;

import com.hsnam.message.publisher.model.Person;
import com.hsnam.message.publisher.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/direct")
    public Person sendDirectExchange(){
        Person person = new Person();
        person.setGroup("direct");
        person.setAge(10);
        person.setName("hsnam");
        publisherService.sendDirectExchange("hsnam.key", person);

        return person;
    }

    @GetMapping("/fanout")
    public Person sendFanoutExchange(){
        Person person = new Person();
        person.setGroup("fanout");
        person.setAge(10);
        person.setName("hsnam");
        publisherService.sendFanoutExchange(person);

        return person;
    }

    @GetMapping("/topic")
    public Person sendTopicExchange(){
        Person person = new Person();
        person.setGroup("topic");
        person.setAge(10);
        person.setName("hsnam");
        publisherService.sendTopicExchange("foo.hsnam.task", person);
        //publisherService.sendTopicExchange("#.hsnam.task", person);

        return person;
    }

    @GetMapping("/headers")
    public Person sendheadersExchange(){
        Person person = new Person();
        person.setGroup("headers");
        person.setAge(10);
        person.setName("hsnam");
        //publisherService.sendDirectExchange("hsnam.key", person);

        return person;
    }


}
