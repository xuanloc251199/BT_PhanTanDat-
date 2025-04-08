package com.phantandat.demo.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attributes")
public class attributes {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        @Column(name = "attributes_name", columnDefinition = "VARCHAR(255) NOT NULL")
        private String attributes_name;

        @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
        private LocalDateTime created_at;

        @Column(name = "update_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
        private LocalDateTime updated_at;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "created_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_staff_account"))
        @OnDelete(action = OnDeleteAction.SET_NULL)
        private staff_accounts staff_accounts_cr;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "updated_by", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_staff_account"))
        @OnDelete(action = OnDeleteAction.SET_NULL)
        private staff_accounts staff_accounts_ud;

        @OneToMany(mappedBy = "attributes_id", fetch = FetchType.LAZY, cascade = {
                        CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.REMOVE }, orphanRemoval = true)
        private Set<product_attribute> attributes = new HashSet<>();

        

        // @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REFRESH,
        // CascadeType.MERGE })
        // @JoinTable(name = "product_attribute", joinColumns = @JoinColumn(name =
        // "attribute_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
        // private Set<Product> product = new HashSet<>();
}
