package com.primepro.ims.service;

import com.primepro.ims.model.Product;
import com.primepro.ims.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

import static com.primepro.ims.util.CommonUtils.generateCode;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<String> addProduct(Product product){
        product.setProductCode(generateCode(product.getProductBrand()));
        if(Objects.nonNull(productRepository.save(product))){
            return ResponseEntity.ok("Product added Successfully");//200
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product is not saved reenter the product");

    }


    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
