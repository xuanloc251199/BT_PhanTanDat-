package com.phantandat.example17.repository;

import com.phantandat.example17.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
}

