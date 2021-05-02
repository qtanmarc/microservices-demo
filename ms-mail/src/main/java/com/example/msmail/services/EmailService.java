package com.example.msmail.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.msmail.dtos.UserDto;
import com.example.msmail.entities.Mail;
import com.example.msmail.repositories.IMailRepository;
import com.netflix.discovery.converters.Auto;

/**
 * @author taq
 */
@Service
public class EmailService implements IEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private IMailRepository mailRepository;

    @Override public void sendMessage(UserDto input) {
        Mail newMail = new Mail();
        newMail.setTo(input.getUsername());
        newMail.setSubject("subject");
        newMail.setText("text");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(newMail.getTo());
        message.setSubject(newMail.getSubject());
        message.setText(newMail.getText());

        mailRepository.save(newMail);
//        emailSender.send(message);
        LOGGER.info("Mail sent to {}", input.getUsername());
    }
}
