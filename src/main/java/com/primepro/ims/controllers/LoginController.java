package com.primepro.ims.controllers;

import com.primepro.ims.model.Login;
import com.primepro.ims.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<String> validateLogin(@RequestBody Login login) {
        if (Objects.nonNull(login)) {
            return loginService.validateLogin(login);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username & password");
    }

}
