package com.example.msmail.kafka.consumer;

import java.util.concurrent.CountDownLatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import com.example.msmail.dtos.UserDto;
import com.example.msmail.services.IEmailService;
import com.netflix.discovery.converters.Auto;

/**
 * @author taq
 */
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private IEmailService emailService;

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receive(UserDto payload) {
        LOGGER.info("received payload='{}'", payload);
        emailService.sendMessage(payload);
        latch.countDown();
    }
}
