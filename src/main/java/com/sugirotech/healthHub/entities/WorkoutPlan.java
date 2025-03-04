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


@Entity
@Table(name = "workout_plan")
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

    // FK USER, FK PROFESSIONAL

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userClient;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private UserProfessional userProfessional;


    public WorkoutPlan(InWorkoutPlanDTO data) {
        this.name = data.name();
        this.workout_type = data.workout_type();
    }
}
