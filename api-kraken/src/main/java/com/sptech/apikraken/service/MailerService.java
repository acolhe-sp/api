package com.sptech.apikraken.service;

import com.sptech.apikraken.entity.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailerService {

    @Autowired
    JavaMailSender mailSender;

    public void sendMail(Mailer email) {
        try {
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setFrom(email.getEmailFrom());
            msg.setTo(email.getEmailTo());
            msg.setSubject(email.getSubject());
            msg.setText(email.getText());
            mailSender.send(msg);
        } catch (MailException ignored) {
        }
    }
}
