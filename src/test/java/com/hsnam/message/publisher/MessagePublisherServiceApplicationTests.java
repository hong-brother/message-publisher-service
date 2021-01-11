package com.hsnam.message.publisher;

import com.hsnam.message.publisher.model.Email;
import com.hsnam.message.publisher.service.EmailMsgSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MessagePublisherServiceApplicationTests {

    @Autowired
    private EmailMsgSender emailMsgSender;

    @Test
    void contextLoads() {
        Email email = new Email();
        email.setBody("info@example.com");
        email.setTo("Hello");
        emailMsgSender.sendEmail("test.0001", email);
    }

}
