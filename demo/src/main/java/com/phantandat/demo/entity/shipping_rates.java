package com.phantandat.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;
import java.util.UUID;

@Entity
@Table(name = "shipping_rates")
public class shipping_rates {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "shipping_zone_id", referencedColumnName = "id", nullable = false)
    private shippings_zones shippingZone;

    @Column(name = "weight_unit", columnDefinition = "VARCHAR(10)")
    @Check(constraints = "weight_unit IN ('g', 'kg')")
    private String weightUnit;

    @Column(name = "min_value", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double minValue;

    @Column(name = "max_value", columnDefinition = "NUMERIC")
    @Check(constraints = "max_value > min_value OR max_value IS NULL")
    private Double maxValue;

    @Column(name = "no_max", columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean noMax;

    @Column(name = "price", columnDefinition = "NUMERIC NOT NULL DEFAULT 0")
    private Double price;

}