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
@Table(name = "customer_addresses")
public class customer_addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private customers customer_id;

    @Column(name = "address_line1", nullable = true)
    private String address_line1;

    @Column(name = "address_line2")
    private String address_line2;

    @Column(name = "phone_number", columnDefinition = "VARCHAR(255) NOT NULL")
    private String phone_number;

    @Column(name = "dial_code", columnDefinition = "VARCHAR(100) NOT NULL")
    private String dial_code;

    @Column(name = "country", columnDefinition = "VARCHAR(255) NOT NULL")
    private String country;

    @Column(name = "postal_code", columnDefinition = "VARCHAR(255) NOT NULL")
    private String postal_code;

}
