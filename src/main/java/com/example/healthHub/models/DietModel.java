package com.example.healthHub.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_Diet")
public class DietModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Double schedule;
    private String title;
    private String food;
    private Double quantity;
    private String category;
    private String unit;
    @OneToOne
    @JoinColumn(name = "fk_plan", referencedColumnName = "id")
    private DietPlanModel fk_plan;
    @OneToOne
    @JoinColumn(name = "fk_info", referencedColumnName = "id")
    private InfoNutritionalModel fk_info;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getSchedule() {
        return schedule;
    }

    public void setSchedule(Double schedule) {
        this.schedule = schedule;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public DietPlanModel getFk_plan() {
        return fk_plan;
    }

    public void setFk_plan(DietPlanModel fk_plan) {
        this.fk_plan = fk_plan;
    }

    public InfoNutritionalModel getFk_info() {
        return fk_info;
    }

    public void setFk_info(InfoNutritionalModel fk_info) {
        this.fk_info = fk_info;
    }
}
