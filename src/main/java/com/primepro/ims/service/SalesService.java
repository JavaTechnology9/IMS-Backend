package com.primepro.ims.service;

import com.primepro.ims.model.Customer;
import com.primepro.ims.model.Product;
import com.primepro.ims.model.SalesDetails;
import com.primepro.ims.model.SalesInfo;
import com.primepro.ims.repository.CustomerRepository;
import com.primepro.ims.repository.ProductRepository;
import com.primepro.ims.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<String> addSalesRecord(SalesDetails salesDetails){
        Product product = loadProduct(salesDetails.getProductName());
        Customer customer = loadCustomer(salesDetails.getSoldBy());
        SalesInfo salesInfo=new SalesInfo();
        salesInfo.setDateTime(LocalDateTime.now());
        salesInfo.setSoldBy(salesDetails.getSoldBy());
        salesInfo.setRevenue(revenue(salesDetails.getSellPrice(),product.getCostPrice()));
        salesInfo.setCustomer(customer);
        salesInfo.setProduct(product);
        SalesInfo save = salesRepository.save(salesInfo);
        return ResponseEntity.ok("Successfully added sales record");

    }

    private Customer loadCustomer(String customerName) {
        Optional<Customer> byCustomerName = customerRepository.findByCustomerName(customerName);
        if(byCustomerName.isPresent())
            return byCustomerName.get();
        return null;
    }

    private String revenue(String sellingPrice, String costPrice) {
        return String.valueOf(Double.parseDouble(sellingPrice) - Double.parseDouble(costPrice));
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
