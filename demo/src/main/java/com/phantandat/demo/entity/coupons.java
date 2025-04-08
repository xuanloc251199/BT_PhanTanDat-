package com.phantandat.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupons")
public class coupons {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "code", columnDefinition = "VARCHAR(50) NOT NULL UNIQUE")
    private String code;

    @Column(name = "discount_value", columnDefinition = "NUMERIC")
    private BigDecimal discountValue;

    @Column(name = "discount_type", columnDefinition = "VARCHAR(50) NOT NULL")
    private String discount_type;

    @Column(name = "time_used", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private int timeUsed;

    @Column(name = "max_usage", columnDefinition = "NUMERIC DEFAULT null")
    private Integer maxUsage;

    @Column(name = "order_amount_limit", columnDefinition = "NUMERIC DEFAULT null")
    private BigDecimal orderAmountLimit;

    @Column(name = "coupon_start_date", columnDefinition = "DATETIME")
    private LocalDateTime coupon_start_date;

    @Column(name = "coupon_end_date", columnDefinition = "DATETIME")
    private LocalDateTime coupon_end_date;

    @OneToMany(mappedBy = "coupon_id", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE
    }, orphanRemoval = true)
    private Set<product_coupons> product_coupon_id = new HashSet<>();
}