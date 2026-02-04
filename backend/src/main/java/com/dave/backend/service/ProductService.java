package com.dave.backend.service;

import com.dave.backend.model.Product;
import com.dave.backend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById (int id) {
        return repo.findById(id).orElse(null);
    }
}
