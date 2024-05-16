package com.sugirotech.healthHub.entities;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.enums.workout.EnumTrainingOptions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private EnumTrainingOptions options;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user")
    private User fk_user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_professional")
    private UserProfessional fk_professional;

    @ManyToOne
    @JoinColumn(name = "fk_workout", referencedColumnName = "id")
    private List<Workout> fk_workout;

}
