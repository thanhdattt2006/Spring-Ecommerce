package com.dave.backend.controller;

import com.dave.backend.model.Product;
import com.dave.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<Product> getProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(
            @RequestPart Product product,
            @RequestPart MultipartFile imageFile
    ) {
        try {
            Product savedProduct = service.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (Exception e) {
            // Nếu lỗi (ví dụ file quá to, lỗi DB) thì trả về 500 Internal Server Error kèm message
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{id}/image")
    public ResponseEntity<byte[]> getImageProductById(@PathVariable int id) {
        // 1. Nhờ Service móc thằng Product ra từ DB
        Product product = service.getProductById(id);

        // 2. Chộp lấy cục mảng byte (imageData)
        byte[] imageFile = product.getImageData();

        // 3. Trả về cho Frontend, NHƯNG phải báo cho nó biết đây là ảnh loại gì (png, jpeg...)
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType())) // Bùa chú định dạng ảnh
                .body(imageFile); // Quăng cục byte[] vào Body
    }
}
