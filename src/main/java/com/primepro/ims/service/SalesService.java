package com.primepro.ims.service;

import com.primepro.ims.model.*;
import com.primepro.ims.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CurrentStockRepository currentStockRepository;

    public ResponseEntity<String> addSalesRecord(SalesDetails salesDetails){
        Product product = loadProduct(salesDetails.getProductName());
        Customer customer = loadCustomer(salesDetails.getSoldBy());
        SalesInfo salesInfo=new SalesInfo();
        salesInfo.setDateTime(LocalDateTime.now());
        salesInfo.setSoldBy(salesDetails.getSoldBy());
        salesInfo.setRevenue(revenue(salesDetails.getSellPrice(),product.getCostPrice()));
        salesInfo.setQuantity(salesDetails.getQuantity());
        salesInfo.setCustomer(customer);
        salesInfo.setProduct(product);
        SalesInfo save = salesRepository.save(salesInfo);
        saveCurrentStock(salesDetails,product);
        return ResponseEntity.ok("Successfully added sales record");

    }

    private void saveCurrentStock(SalesDetails salesDetails, Product product) {
        PurchaseInfo purchaseInfo = loadPurchase(product);
        if(Objects.nonNull(purchaseInfo)){
            CurrentStock currentStock=new CurrentStock();
            currentStock.setQuantity(purchaseInfo.getQuantity()-salesDetails.getQuantity());
            currentStock.setProducts(product);
            currentStock.setPurchaseInfo(purchaseInfo);
            currentStockRepository.save(currentStock);
        }

    }

    private PurchaseInfo loadPurchase(Product product) {
        Optional<PurchaseInfo> byProductId = purchaseRepository.findByProductId(product.getId());
        if(byProductId.isPresent()) return byProductId.get();;
        return null;
    }

    private Customer loadCustomer(String customerName) {
        Optional<Customer> byCustomerName = customerRepository.findByCustomerName(customerName);
        if(byCustomerName.isPresent())
            return byCustomerName.get();
        return null;
    }

    private double revenue(double sellingPrice, double costPrice) {
        return sellingPrice - costPrice;
    }

    private Product loadProduct(String productName) {
        Optional<Product> byProductName = productRepository.findByProductName(productName);
        if(byProductName.isPresent()){
            return byProductName.get();
        }
        return null;
    }

    public Iterable<SalesInfo> loadAllSalesRecords() {
        return salesRepository.findAll();
    }
}
