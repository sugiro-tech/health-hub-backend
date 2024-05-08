package com.example.healthHub.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_Info")
public class InfoNutritionalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double kcal;
    private Double ptn;
    private Double cho;
    private Double lip;
    private Double sat;
    private Double fibers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getKcal() {
        return kcal;
    }

    public void setKcal(Double kcal) {
        this.kcal = kcal;
    }

    public Double getPtn() {
        return ptn;
    }

    public void setPtn(Double ptn) {
        this.ptn = ptn;
    }

    public Double getCho() {
        return cho;
    }

    public void setCho(Double cho) {
        this.cho = cho;
    }

    public Double getLip() {
        return lip;
    }

    public void setLip(Double lip) {
        this.lip = lip;
    }

    public Double getSat() {
        return sat;
    }

    public void setSat(Double sat) {
        this.sat = sat;
    }

    public Double getFibers() {
        return fibers;
    }

    public void setFibers(Double fibers) {
        this.fibers = fibers;
    }
}
