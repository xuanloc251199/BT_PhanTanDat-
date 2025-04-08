package com.phantandat.example403.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phantandat.example403.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}