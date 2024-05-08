package com.sugirotech.healthHub.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer rounds;
    private Integer repetitions;
    private Double exercise_interval;
    private Double interval_next;

    

}
