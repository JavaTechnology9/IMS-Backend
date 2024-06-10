package com.primepro.ims.service;

import com.primepro.ims.exception.ProductException;
import com.primepro.ims.exception.PurchaseException;
import com.primepro.ims.exception.SupplierNotFoundException;
import com.primepro.ims.model.*;
import com.primepro.ims.repository.ProductRepository;
import com.primepro.ims.repository.PurchaseRepository;
import com.primepro.ims.repository.SupplierRepository;
import com.primepro.ims.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductRepository productRepository;
    public ResponseEntity<String> addPurchase(PurchaseDetails purchaseDetails) throws PurchaseException {
        PurchaseInfo purchaseInfo=new PurchaseInfo();
        purchaseInfo.setPurchaseDate(LocalDateTime.now());
        purchaseInfo.setSupplier(loadSupplier(purchaseDetails.getSupplierName()));
        purchaseInfo.setPrice(purchaseDetails.getCostPrice());
        purchaseInfo.setQuantity(purchaseDetails.getQuantity());
        purchaseInfo.setProduct(saveProduct(purchaseDetails));
        try{
            PurchaseInfo save = purchaseRepository.save(purchaseInfo);
            if (Objects.nonNull(save)) {
                return ResponseEntity.ok("Successfully Inserted Purchase Record");
            }
        }catch (Exception e){
            throw new PurchaseException("Purchase record insertion failed");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Purchase record insertion failed");
    }



    private Supplier loadSupplier(String supplierName) throws SupplierNotFoundException {
        Optional<Supplier> bySupplierName = supplierRepository.findBySupplierName(supplierName);
        if(bySupplierName.isPresent()){
            return bySupplierName.get();
        }
        throw new SupplierNotFoundException("Supplier Details are not found");
    }

    private Product saveProduct(PurchaseDetails purchaseInfo) throws ProductException {
        Product product=new Product();
        product.setProductCode(CommonUtils.generateCode(purchaseInfo.getProductName()));
        product.setProductName(purchaseInfo.getProductName());
        product.setProductBrand(purchaseInfo.getBrand());
        product.setQuantity(purchaseInfo.getQuantity());
        product.setCostPrice(purchaseInfo.getCostPrice());
        product.setSellingPrice(purchaseInfo.getSellingPrice());
        try{
            return productRepository.save(product);
        }catch (Exception e){
            throw new ProductException(e.getMessage());
        }

    }

    public Iterable<ProductDetails> loadPurchaseData() {
        List<ProductDetails> productDetailsList=new ArrayList<>();
        for (PurchaseInfo purchaseInfo : purchaseRepository.findAll()) {
            ProductDetails productDetails=new ProductDetails();
            productDetails.setProductCode(purchaseInfo.getProduct().getProductCode());
            productDetails.setProductName(purchaseInfo.getProduct().getProductName());
            productDetails.setQuantity(purchaseInfo.getQuantity());
            productDetails.setTotalCost(totalCost(purchaseInfo.getPrice(),purchaseInfo.getQuantity()));
            productDetails.setPurchaseId(purchaseInfo.getPurchaseId());
            productDetailsList.add(productDetails);

        }
        return productDetailsList;

    }

    private double totalCost(String price, int quantity) {
        return  Double.parseDouble(price)*quantity;
    }
}
