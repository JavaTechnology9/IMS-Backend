package com.primepro.ims.controllers;

import com.primepro.ims.model.Product;
import com.primepro.ims.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        if (Objects.nonNull(product)) {
            return productService.addProduct(product);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Product details not provided");

    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<Iterable<Product>> getAllProducts(){
        Iterable<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }
}
