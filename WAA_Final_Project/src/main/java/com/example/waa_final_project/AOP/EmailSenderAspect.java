package com.example.waa_final_project.AOP;

import com.example.waa_final_project.Dto.LogIn.OfferDTO;
import com.example.waa_final_project.Service.EmailService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmailSenderAspect {
    @Autowired
    EmailService emailService;

    @Pointcut("@annotation(com.example.waa_final_project.AOP.annotation.SendEmail)")
    public void execute() {
    }

    @After("execute()")
    public void send(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 2) {
            OfferDTO offer = (OfferDTO) args[2];
            emailService.send("Interest of property", offer.getOfferDescription(), offer.getAgentEmail());
        }

    }
}
