package com.phantandat.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.OffsetDateTime;

@Entity
@Table(name = "orders")

public class Order {

    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_order_coupon"), nullable = true)
    private coupons coupon;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_order_customer"), nullable = false)
    private customers customer;

    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_order_status"), nullable = true)
    private order_statuses orderStatus;

    @Column(name = "order_approved_at")
    private OffsetDateTime orderApprovedAt;

    @Column(name = "order_delivered_carrier_date")
    private OffsetDateTime orderDeliveredCarrierDate;

    @Column(name = "order_delivered_customer_date")
    private OffsetDateTime orderDeliveredCustomerDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "updated_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_order_updated_by"), nullable = true)
    private staff_accounts updatedBy;
}
