package com.phantandat.example404.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phantandat.example404.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findCategorysByProductsId(Long productId);
}
