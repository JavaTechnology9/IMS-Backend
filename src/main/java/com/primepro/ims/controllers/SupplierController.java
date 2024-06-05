package com.primepro.ims.controllers;

import com.primepro.ims.model.Supplier;
import com.primepro.ims.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/addSupplier")
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier){
        if(Objects.nonNull(supplier) && !supplier.getSupplierName().isBlank()){
            return supplierService.addSupplier(supplier);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Supplier details are empty..");
    }
    @GetMapping("/loadSuppliers")
    public Iterable<Supplier> loadSuppliers(){
        return supplierService.loadSuppliers();
    }
}
