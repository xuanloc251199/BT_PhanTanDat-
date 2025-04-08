package com.phantandat.example402.service;

import java.util.List;
import com.phantandat.example402.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategorys();

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);
}
