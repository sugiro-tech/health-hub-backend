package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.enums.workout.EnumWeekdays;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @JoinColumn(name = "fk_workout", referencedColumnName = "id")
    private WorkoutPlan workoutPlan;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL)
    private List<Exercise> exercises;
}
