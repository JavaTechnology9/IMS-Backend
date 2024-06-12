package com.primepro.ims.service;

import com.primepro.ims.exception.EmailException;
import com.primepro.ims.util.EmailService;
import com.primepro.ims.util.CommonUtils;
import com.primepro.ims.model.Registration;
import com.primepro.ims.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private EmailService emailService;

    public Registration save(Registration registration) {
        registration.setPassword(CommonUtils.hashPassword(registration.getPassword()));
        return registrationRepository.save(registration);
    }
    public Optional<Registration> findByUsername(String username) {
        return registrationRepository.findByUsername(username);
    }
    public void sendWelcomeEmail(String email) throws EmailException {
        emailService.sendWelcomeEmail(email,"Welcome to IMS Application");

        /*SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Welcome to IMS Application");
        message.setText(getHtmlWelcomeEmail(email));
        message.setFrom("java_primepro@outlook.com");*/



    }

    public Iterable<Registration> loadRegistrationData() {
        return registrationRepository.findAll();
    }
}
