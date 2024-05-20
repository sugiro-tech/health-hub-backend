package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.enums.workout.EnumWorkoutType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user")
//    private User fk_user;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_professional")
//    private UserProfessional fk_professional;
//
//    @OneToMany(mappedBy = "workoutPlan", cascade = CascadeType.ALL)
//    private List<Workout> workouts;
}
