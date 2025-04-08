package com.phantandat.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(nullable = false, unique = true)
        private UUID slug;

        @Column(name = "product_name", length = 255, nullable = false)
        private String productName;

        @Column(length = 255, nullable = false)
        private String sku;

        @Column(name = "sale_price", columnDefinition = "NUMERIC DEFAULT 0")
        private Double salePrice;

        @Column(name = "compare_price", columnDefinition = "NUMERIC")
        private Double comparePrice;

        @Column(name = "buying_price", columnDefinition = "NUMERIC")
        private Double buyingPrice;

        @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 0")
        private Integer quantity;

        @Column(name = "short_description", length = 165, nullable = false)
        private String shortDescription;

        @Column(name = "product_description", columnDefinition = "TEXT", nullable = false)
        private String productDescription;

        @Column(name = "product_type", length = 50, columnDefinition = "VARCHAR(50) CHECK (product_type IN ('simple', 'variable'))")
        private String productType;

        @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
        private boolean published;

        @Column(name = "disable_out_of_stock", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
        private boolean disableOutOfStock;

        @Column(columnDefinition = "TEXT")
        private String note;

        @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime createdAt;

        @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
        private LocalDateTime updatedAt;

        @Column(name = "created_by")
        private UUID createdBy;

        @Column(name = "updated_by")
        private UUID updatedBy;

        // @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
        // CascadeType.MERGE })
        // @JoinTable(name = "products_categories", joinColumns = @JoinColumn(name =
        // "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
        // private Set<Categories> categories = new HashSet<>();

        @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.REMOVE }, orphanRemoval = true)
        private Set<Products_categories> products_categories = new HashSet<>();

        @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = {
                        CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.REMOVE }, orphanRemoval = true)
        private Set<product_attribute> product_attribute = new HashSet<>();

        @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = {
                        CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE
        }, orphanRemoval = true)
        private Set<variants> variants = new HashSet<>();

        @OneToMany(mappedBy = "product_id", fetch = FetchType.LAZY, cascade = {
                        CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE
        }, orphanRemoval = true)
        private Set<product_coupons> product_coupun_id = new HashSet<>();

        @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
        @JoinTable(name = "products_suppliers", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
        private Set<suppliers> suppliers = new HashSet<>();

        // @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH,
        // CascadeType.MERGE })
        // @JoinTable(name = "product_attribute", joinColumns = @JoinColumn(name =
        // "product_id"), inverseJoinColumns = @JoinColumn(name = "attribute_id"))
        // private Set<attributes> product = new HashSet<>();
}