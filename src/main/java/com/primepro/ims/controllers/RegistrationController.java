package com.primepro.ims.controllers;

import com.primepro.ims.model.Registration;
import com.primepro.ims.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/registration")
    public ResponseEntity<String> saveRegistrationData(@RequestBody Registration registration){
        if(Objects.nonNull(registration)){
            Optional<Registration> byUsername = registrationService.findByUsername(registration.getUsername());
            if(byUsername.isEmpty()){
                if(registrationService.save(registration)!=null){
                    registrationService.sendWelcomeEmail(registration.getUsername());
                    return ResponseEntity.ok("Registration successful");
                }else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed");
                }
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Registration details not provided");
    }

}
