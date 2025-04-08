package com.phantandat.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
                                                       
    private Integer id;

    @Column(name = "iso", columnDefinition = "CHAR(2) NOT NULL")
    private String iso;

    @Column(name = "name", columnDefinition = "VARCHAR(80) NOT NULL")
    private String name;

    @Column(name = "upper_name", columnDefinition = "VARCHAR(80) NOT NULL")
    private String upperName;

    @Column(name = "iso3", columnDefinition = "CHAR(3) DEFAULT NULL")
    private String iso3;

    @Column(name = "num_code", columnDefinition = "SMALLINT DEFAULT NULL")
    private Short numCode;

}