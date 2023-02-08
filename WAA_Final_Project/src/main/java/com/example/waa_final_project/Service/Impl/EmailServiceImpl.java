package com.example.waa_final_project.Service.Impl;

import com.example.waa_final_project.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sendFrom;
    @Override
    public void send(String subject, String body, String toEmail) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sendFrom);
            message.setSubject(subject);
            message.setText(body);
            message.setTo(toEmail);
            javaMailSender.send(message);
            System.out.println("message sent...");
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }
}
