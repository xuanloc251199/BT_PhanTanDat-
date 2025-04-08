package com.phantandat.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "categories")

public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_CATEGORY_PARENT"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Categories parent_id;

    @OneToMany(mappedBy = "parent_id", fetch = FetchType.LAZY)
    private Set<Categories> children = new HashSet<>();

    @Column(name = "category_name", length = 255, nullable = false, unique = true)
    private String categoryName;

    @Column(name = "category_description", columnDefinition = "TEXT")
    private String categoryDescription;
    @Column(nullable = true)
    private String icon;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private String placeholder;

    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "created_by")
    private UUID createdBy; 

    @Column(name = "updated_by")
    private UUID updatedBy; 

    // @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    // private Set<Product> products = new HashSet<>();
    
    @OneToMany(mappedBy = "category_id", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE }, orphanRemoval = true)
    private Set<Products_categories> products_categories = new HashSet<>();
}
