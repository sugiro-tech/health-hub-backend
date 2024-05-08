package com.example.healthHub.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_DietPlan")
public class DietPlanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "fk_professional", referencedColumnName = "id")
    private UserProfessionalModel fk_professional;
    @ManyToOne
    @JoinColumn(name = "fk_client", referencedColumnName = "id")
    private UserClientModel fk_client;
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

    public UserClientModel getFk_client() {
        return fk_client;
    }

    public void setFk_client(UserClientModel fk_client) {
        this.fk_client = fk_client;
    }
}
