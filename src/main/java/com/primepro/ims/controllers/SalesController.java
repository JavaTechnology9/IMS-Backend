package com.primepro.ims.controllers;

import com.primepro.ims.model.SalesDetails;
import com.primepro.ims.model.SalesInfo;
import com.primepro.ims.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    private SalesService salesService;

    @PostMapping("/addSale")
    public ResponseEntity<String> addSaleRecord(@RequestBody SalesDetails salesDetails){
        if(Objects.nonNull(salesDetails) && !Objects.isNull(salesDetails.getSoldBy())){
           return  salesService.addSalesRecord(salesDetails);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Empty Sales Records found");
    }
    @GetMapping("/loadAllSales")
    public Iterable<SalesInfo> getAllSales(){
        return salesService.loadAllSalesRecords();
    }
}
