package com.phantandat.example404.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, unique = true)
    private String photo;
    @Column(nullable = false)
    private double price;

    public Product(String title, String description, String photo, double price) {
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.price = price;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "products_categories", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
            @JoinColumn(name = "category_id") })
    private Set<Category> categories = new HashSet<>();

    public void addCategory(Category Category) {
        this.categories.add(Category);
        Category.getProducts().add(this);
    }

    public void removeCategory(long CategoryId) {
        Category Category = this.categories.stream().filter(t -> t.getId() == CategoryId).findFirst().orElse(null);
        if (Category != null) {
            this.categories.remove(Category);
            Category.getProducts().remove(this);
        }
    }
}