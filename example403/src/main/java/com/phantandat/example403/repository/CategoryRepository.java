package com.phantandat.example403.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.phantandat.example403.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
