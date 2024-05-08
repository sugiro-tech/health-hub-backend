package com.sugirotech.healthHub.entities;

import jakarta.persistence.*;

import java.util.List;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private String neighborhood;
    private String city;
    private String state;
    private Integer number;

    // Fazer Campo ManytoMany com user

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "professional_address", joinColumns = @JoinColumn(name = "fk_address"),
    inverseJoinColumns = @JoinColumn("fk_professional"))
    private List<>

}
