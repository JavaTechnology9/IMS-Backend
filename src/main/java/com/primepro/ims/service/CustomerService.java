package com.primepro.ims.service;

import com.primepro.ims.model.Customer;
import com.primepro.ims.repository.CustomerRepository;
import com.primepro.ims.util.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.primepro.ims.util.CommonUtils.generateCode;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmailService emailService;

    public ResponseEntity<String> addCustomer(Customer customer){
        customer.setCustomerCode(generateCode(customer.getCustomerName()));
        if(Objects.nonNull(customerRepository.save(customer))){
            emailService.sendWelcomeEmail(customer.getEmail(),"Welcome to IMS Application");
            return ResponseEntity.ok("Customer Record added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Customer is not saved re enter the Customer");
    }
    public Iterable<Customer> getAllCustomers(){
         return customerRepository.findAll();
    }


}
