package com.phantandat.demo.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "staff_accounts")
public class staff_accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    @JsonIgnore
    private Role role;

    @Column(nullable = true)
    private String first_name;

    @Column(nullable = true)
    private String last_name;

    @Column(nullable = true)
    private String phone_number;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String password_hash;

    @Column(columnDefinition = "tinyint(1) default 1")
    private boolean active;

    @Column(nullable = true)
    private String image;

    @Column(nullable = true)
    private String placeholder;

    @Column(nullable = false)
    private Date created_at;

    @Column(nullable = false)
    private Date updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private staff_accounts createdBy;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL)
    private List<staff_accounts> subCreatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private staff_accounts updatedBy;

    @OneToMany(mappedBy = "updatedBy", cascade = CascadeType.ALL)
    private List<staff_accounts> subUpdatedBy;

}
