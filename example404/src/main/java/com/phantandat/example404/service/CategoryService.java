package com.phantandat.example404.service;

import java.util.List;
import com.phantandat.example404.entity.Category;

public interface CategoryService {
    Category createCategory(Category category);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);

    List<Category> findCategorysByProductsId(Long productId);
}
