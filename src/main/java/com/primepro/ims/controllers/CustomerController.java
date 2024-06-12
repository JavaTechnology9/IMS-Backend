package com.primepro.ims.controllers;

import com.primepro.ims.exception.EmailException;
import com.primepro.ims.model.Customer;
import com.primepro.ims.service.CustomerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    @Transactional(rollbackOn = EmailException.class)
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer){
        if (Objects.nonNull(customer)) {
            try {
                return customerService.addCustomer(customer);
            } catch (EmailException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Customer details not provided");
    }
    @GetMapping("/getAllCustomers")
    public Iterable<Customer> loadCustomers(){
        return customerService.getAllCustomers();
    }
}
