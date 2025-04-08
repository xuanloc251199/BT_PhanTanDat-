package com.phantandat.demo.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "attribute_value")
public class attribute_values {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_ATTRIBUTE"))
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private attributes attributes;

    @Column(name = "atribute_value", columnDefinition = "VARCHAR(255) NOT NULL")
    private String atribute_value;

    @Column(name = "color", columnDefinition = "VARCHAR(50) DEFAULT NULL")
    private String color;
    @OneToMany(mappedBy = "attribute_value_id", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.REMOVE
    }, orphanRemoval = true)
    private Set<product_attribute_value> product_attribute_value = new HashSet<>();

}
