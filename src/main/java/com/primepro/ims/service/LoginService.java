package com.primepro.ims.service;

import com.primepro.ims.config.PasswordUtil;
import com.primepro.ims.model.Login;
import com.primepro.ims.model.Registration;
import com.primepro.ims.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private RegistrationRepository repository;

    public ResponseEntity<String> validateLogin(Login login) {
        Optional<Registration> byUsername = repository.findByUsername(login.getUsername());
        if (byUsername.isPresent()) {
            Registration registration = byUsername.get();
            if (PasswordUtil.checkPassword(login.getPassword(), registration.getPassword())) {
                return ResponseEntity.ok("Login successful");
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Password does not match");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username not found");
        }
    }
}
