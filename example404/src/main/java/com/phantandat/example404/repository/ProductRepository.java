package com.phantandat.example404.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phantandat.example404.entity.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByCategoriesId(Long categoryId);

}
