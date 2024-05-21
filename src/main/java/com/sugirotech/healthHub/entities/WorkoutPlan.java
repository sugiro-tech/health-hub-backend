package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.dtos.workoutplan.InWorkoutPlanDTO;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.enums.workout.EnumWorkoutType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

// TODO REVER

@Entity
@Table(name = "workoutPlan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EnumWorkoutType workout_type;

    // Relaçao um para muitos na tabela 'workout'

    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Workout> workouts = new HashSet<>();

    // FK USER, FK PROFESSIONAL

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userClient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "professional_id", referencedColumnName = "id")
    private UserProfessional userProfessional;

    public WorkoutPlan(InWorkoutPlanDTO data) {
        this.name = data.name();
        this.workout_type = data.workout_type();
    }
}
