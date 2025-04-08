package com.phantandat.demo.entity;

import java.util.UUID;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_shipping_info")
public class Product_shipping_info {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "weight", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double weight;

    @Column(name = "weight_unit", length = 10, columnDefinition = "VARCHAR(10) CHECK (weight_unit IN ('g', 'kg'))")
    private String weight_unit;

    @Column(name = "volume", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double volume;

    @Column(name = "volume_unit", length = 10, columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private String volume_unit;

    @Column(name = "dimension_width", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double dimension_width;

    @Column(name = "dimension_height", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double dimension_height;

    @Column(name = "dimension_depth", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double dimension_depth;

    @Column(name = "dimension_unit", length = 10, columnDefinition = "VARCHAR(10) CHECK (dimension_unit IN ('l', 'ml'))")
    private String dimension_unit;
}
