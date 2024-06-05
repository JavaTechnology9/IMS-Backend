package com.primepro.ims.service;

import com.primepro.ims.model.Supplier;
import com.primepro.ims.repository.SupplierRepository;
import com.primepro.ims.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public ResponseEntity<String> addSupplier(Supplier supplier){
        supplier.setSupplierCode(CommonUtils.generateCode(supplier.getSupplierName()));
        if(Objects.nonNull(supplierRepository.save(supplier))){
            return ResponseEntity.ok("Supplier record inserted successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to insert Supplier Record");
    }

    public Iterable<Supplier> loadSuppliers(){
        return supplierRepository.findAll();
    }
}
