package com.phantandat.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "variant_option")
@Check(constraints = "compare_price > sale_price OR compare_price = 0")
public class variant_option {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "variant_option", nullable = true)
    private String variant_option;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_gellery"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private gallery image_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_product"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Product product_id;

    @Column(name = "sale_price", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private float sale_price;

    @Column(name = "compare_price", columnDefinition = "NUMERIC DEFAULT 0")
    private float compare_price;

    @Column(name = "buying_price", columnDefinition = "NUMERIC DEFAULT NULL")
    private float buying_price;

    @Column(name = "quantity", columnDefinition = "INTEGER NOT NULL DEFAULT 0")
    private int quantity;

    @Column(name = "sku", columnDefinition = "VARCHAR(255)")
    private String sku;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean active;

    @OneToMany(mappedBy = "variant_option_id", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REMOVE }, orphanRemoval = true)
    private Set<variants> variable = new HashSet<>();
}