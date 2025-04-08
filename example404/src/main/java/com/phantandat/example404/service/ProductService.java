package com.phantandat.example404.service;

import java.util.List;
import com.phantandat.example404.entity.Product;

public interface ProductService {
    List<Product> findProductsByCategoriesId(Long categoryId);

    Product createProduct(Product product);

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    Product updateProduct(Product product);

    void deleteProduct(Long productId);
}
