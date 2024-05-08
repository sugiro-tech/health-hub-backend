package com.example.healthHub.models;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_Services")
public class ServicesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "fk_professional", referencedColumnName = "id")
    private UserProfessionalModel fk_professional;
    private Double price;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserProfessionalModel getFk_professional() {
        return fk_professional;
    }

    public void setFk_professional(UserProfessionalModel fk_professional) {
        this.fk_professional = fk_professional;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
