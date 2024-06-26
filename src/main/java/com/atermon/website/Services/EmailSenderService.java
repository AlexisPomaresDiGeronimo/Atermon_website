package com.atermon.website.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService{
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String toEmail){
        SimpleMailMessage message= new SimpleMailMessage();
        message.setFrom("alexis.pomares@atermon.com");
        message.setTo(toEmail);
        message.setSubject("Test spring boot mail");
        message.setText("Testing spring boot mail");
        mailSender.send(message);
        System.out.println("Mail sent successfully...");
    }
}