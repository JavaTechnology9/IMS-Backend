package com.primepro.ims.service;

import com.primepro.ims.util.EmailService;
import com.primepro.ims.util.PasswordUtil;
import com.primepro.ims.model.Registration;
import com.primepro.ims.repository.RegistrationRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private EmailService emailService;

    public Registration save(Registration registration) {
        registration.setPassword(PasswordUtil.hashPassword(registration.getPassword()));
        return registrationRepository.save(registration);
    }
    public Optional<Registration> findByUsername(String username) {
        return registrationRepository.findByUsername(username);
    }
    public void sendWelcomeEmail(String email) {
        emailService.sendWelcomeEmail(email,"Welcome to IMS Application");

        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to IMS Application");
        message.setText(getHtmlWelcomeEmail(email));
        message.setFrom("java_primepro@outlook.com");*/



    }

}
