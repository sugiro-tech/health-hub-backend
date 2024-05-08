package com.example.healthHub.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_Address")
public class AddressModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String street;
    private String neighborhood;
    private String city;
    private Integer number;
    private String state;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Professional_Address",
    joinColumns = @JoinColumn(name = "fk_address"),
    inverseJoinColumns = @JoinColumn(name = "fk_professional"))
    private List<UserProfessionalModel> fk_professional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<UserProfessionalModel> getFk_professional() {
        return fk_professional;
    }

    public void setFk_professional(List<UserProfessionalModel> fk_professional) {
        this.fk_professional = fk_professional;
    }
}
