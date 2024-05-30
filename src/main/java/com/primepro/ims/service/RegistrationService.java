package com.primepro.ims.service;

import com.primepro.ims.config.PasswordUtil;
import com.primepro.ims.model.Registration;
import com.primepro.ims.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;


    public Registration save(Registration registration) {
        registration.setPassword(PasswordUtil.hashPassword(registration.getPassword()));
        return registrationRepository.save(registration);
    }
    public Optional<Registration> findByUsername(String username) {
        return registrationRepository.findByUsername(username);
    }
}
