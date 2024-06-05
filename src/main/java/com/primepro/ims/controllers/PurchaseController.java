package com.primepro.ims.controllers;

import com.primepro.ims.exception.PurchaseException;
import com.primepro.ims.model.ProductDetails;
import com.primepro.ims.model.PurchaseDetails;
import com.primepro.ims.model.PurchaseInfo;
import com.primepro.ims.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;
    @PostMapping("/addPurchase")
    public ResponseEntity<String> addPurchase(@RequestBody PurchaseDetails purchaseDetails){
        if(Objects.nonNull(purchaseDetails) && !purchaseDetails.getProductName().isEmpty()){
            try {
                return  purchaseService.addPurchase(purchaseDetails);
            } catch (PurchaseException e) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Purchase details are not found");
    }

    @GetMapping("/loadAllPurchase")
    public Iterable<ProductDetails> loadAllPurchaseData(){
        return purchaseService.loadPurchaseData();
    }


}
