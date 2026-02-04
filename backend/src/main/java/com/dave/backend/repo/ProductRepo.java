package com.dave.backend.repo;

import com.dave.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
    // ko cần viết code, các method tự generate
}
