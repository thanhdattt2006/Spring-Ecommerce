package com.dave.backend.controller;

import com.dave.backend.model.Product;
import com.dave.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
