package com.phantandat.example404.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.phantandat.example404.entity.Product;
import com.phantandat.example404.entity.Category;
import com.phantandat.example404.service.ProductService;
import com.phantandat.example404.repository.ProductRepository;
import com.phantandat.example404.repository.CategoryRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product) {
        // Tạo Set<Category> để lưu trữ các Category đã được quản lý
        Set<Category> managedCategories = new HashSet<>();

        // Lặp qua danh sách categories được gửi từ client
        for (Category category : product.getCategories()) {
            // Tìm kiếm Category trong cơ sở dữ liệu
            Category managedCategory = categoryRepository.findById(category.getId()).orElse(null);
            if (managedCategory != null) {
                // Thêm Category đã được quản lý vào danh sách categories của sản phẩm
                managedCategories.add(managedCategory);
            } else {
                // Nếu không tìm thấy Category, có thể xử lý hoặc ném lỗi
                throw new RuntimeException("Category with ID " + category.getId() + " not found");
            }
        }

        // Gán lại danh sách Category đã quản lý vào sản phẩm
        product.setCategories(managedCategories);

        // Lưu sản phẩm vào cơ sở dữ liệu
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product) {
        // Kiểm tra xem sản phẩm đã tồn tại trong cơ sở dữ liệu chưa
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();

            // Cập nhật các thuộc tính khác
            existingProduct.setTitle(product.getTitle());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPhoto(product.getPhoto());
            existingProduct.setPrice(product.getPrice());

            // Kiểm tra và cập nhật danh mục
            Set<Category> managedCategories = new HashSet<>();
            for (Category category : product.getCategories()) {
                Category managedCategory = categoryRepository.findById(category.getId()).orElse(null);
                if (managedCategory != null) {
                    managedCategories.add(managedCategory);
                } else {
                    throw new RuntimeException("Category with ID " + category.getId() + " not found");
                }
            }

            // Gán lại danh mục cho sản phẩm
            existingProduct.setCategories(managedCategories);

            // Lưu sản phẩm sau khi cập nhật
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + product.getId());
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public List<Product> findProductsByCategoriesId(Long categoryId) {
        List<Product> products = productRepository.findProductsByCategoriesId(categoryId);
        return products;
    }
}
