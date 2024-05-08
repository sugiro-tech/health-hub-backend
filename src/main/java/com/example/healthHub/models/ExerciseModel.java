package com.example.healthHub.models;


import jakarta.persistence.*;

@Entity
@Table(name = "TB_Exercise")
public class ExerciseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer rounds;
    private Integer repetitions;
    private Double exercise_interval;
    private Double interval_next;
    @ManyToOne
    @JoinColumn(name = "fk_chart", referencedColumnName = "id")
    private ChartModel fk_chart;


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

    public Integer getRounds() {
        return rounds;
    }

    public void setRounds(Integer rounds) {
        this.rounds = rounds;
    }

    public Integer getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Integer repetitions) {
        this.repetitions = repetitions;
    }


    public Double getExercise_interval() {
        return exercise_interval;
    }

    public void setExercise_interval(Double exercise_interval) {
        this.exercise_interval = exercise_interval;
    }

    public Double getInterval_next() {
        return interval_next;
    }

    public void setInterval_next(Double interval_next) {
        this.interval_next = interval_next;
    }

    public ChartModel getFk_chart() {
        return fk_chart;
    }

    public void setFk_chart(ChartModel fk_chart) {
        this.fk_chart = fk_chart;
    }
}
