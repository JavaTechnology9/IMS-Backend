package com.primepro.ims.service;

import com.primepro.ims.model.Product;
import com.primepro.ims.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<String> addProduct(Product product){
        product.setProductCode(generateProductCode(product.getProductBrand()));
        if(Objects.nonNull(productRepository.save(product))){
            return ResponseEntity.ok("Product added Successfully");//200
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Product is not saved reenter the product");

    }
    public  String generateProductCode(String brandName) {
        StringBuilder code = new StringBuilder();
        // Generate 3 random letters
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            code.append(brandName.charAt(i));
        }
        // Generate 5 random digits
        for (int i = 0; i < 5; i++) {
            code.append(random.nextInt(10));
        }

        return code.toString();
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
