package com.phantandat.example403.service;

import java.util.List;
import com.phantandat.example403.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);
}