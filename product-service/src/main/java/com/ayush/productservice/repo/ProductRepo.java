package com.ayush.productservice.repo;

import com.ayush.productservice.model.Product;
import com.ayush.productservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
