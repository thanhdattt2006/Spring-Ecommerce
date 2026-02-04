package com.dave.backend.controller;

import com.dave.backend.model.Product;
import com.dave.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api") // Prefix chung cho các API
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products") // URL cuối cùng: localhost:8080/api/products
    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct (@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }   else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
