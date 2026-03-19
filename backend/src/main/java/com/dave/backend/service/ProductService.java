package com.dave.backend.service;

import com.dave.backend.model.Product;
import com.dave.backend.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null); // thêm orElse
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        // 1. Lấy tên file gốc
        product.setImageName(imageFile.getOriginalFilename());

        // 2. Lấy kiểu file (MIME type)
        product.setImageType(imageFile.getContentType());

        // 3. Đọc dữ liệu file thành mảng byte
        product.setImageData(imageFile.getBytes());

        // 4. Lưu xuống Database
        return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product); // Hàm save của JPA vừa dùng để Thêm, vừa dùng để Sửa luôn
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
