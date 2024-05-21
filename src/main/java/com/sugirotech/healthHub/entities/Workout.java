package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.dtos.Workout.InWorkoutDTO;
import com.sugirotech.healthHub.enums.workout.EnumWeekdays;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

// TODO REVER

@Entity
@Table(name = "workout")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EnumWeekdays weekday;

    @ManyToOne
    @JoinColumn(name = "workoutPlan_id", referencedColumnName = "id")
    private WorkoutPlan workoutPlan;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Exercise> exercises = new HashSet<>();

    public Workout(InWorkoutDTO data) {
        this.name = data.name();
        this.weekday = data.weekday();
    }
}
