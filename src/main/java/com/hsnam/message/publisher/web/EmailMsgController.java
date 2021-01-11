package com.hsnam.message.publisher.web;

import com.hsnam.message.publisher.model.Email;
import com.hsnam.message.publisher.model.Person;
import com.hsnam.message.publisher.service.EmailMsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmailMsgController {

    @Autowired
    private EmailMsgSender emailMsgSender;

    @GetMapping("/email")
    public Email send(){
        Email email = new Email();
        email.setBody("info@example.com");
        emailMsgSender.sendEmail("#.hsnam.task", email);
        return email;
    }

    @GetMapping("/direct")
    public Person sendDirectExchange(){
        Person person = new Person();
        person.setAge(10);
        person.setName("hsnam");

        return person;
    }
}
