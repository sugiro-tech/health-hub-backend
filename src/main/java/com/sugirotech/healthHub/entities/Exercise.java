package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.dtos.exercise.InExerciseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "exercise")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer rounds;
    private Integer repetitions;
    private Double exercise_interval;
    private Double interval_next;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    public Exercise(InExerciseDTO data) {
        this.name = data.name();
        this.rounds = data.rounds();
        this.repetitions = data.repetitions();
        this.exercise_interval = data.exercise_interval();
        this.interval_next = data.interval_next();
    }
}
