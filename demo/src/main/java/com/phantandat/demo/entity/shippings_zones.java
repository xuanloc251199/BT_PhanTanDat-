package com.phantandat.demo.entity;

import jakarta.persistence.*;

import org.hibernate.annotations.Check;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shipping_zones")
public class shippings_zones {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String name;

    @Column(name = "display_name", columnDefinition = "VARCHAR(255) NOT NULL")
    private String displayName;

    @Column(name = "active", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean active;

    @Column(name = "free_shipping", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean freeShipping;

    @Column(name = "rate_type", columnDefinition = "VARCHAR(64)")
    @Check(constraints = "rate_type IN ('price')")
    private String rateType;

    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime created_at;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
    private LocalDateTime updated_at;

    @ManyToOne
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private staff_accounts created_by;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private staff_accounts updated_by;

}