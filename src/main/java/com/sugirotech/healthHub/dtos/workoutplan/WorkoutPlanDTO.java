package com.sugirotech.healthHub.dtos.workoutplan;

import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.enums.workout.EnumWorkoutType;

public record WorkoutPlanDTO(

        Long id,
        String name,
        EnumWorkoutType workout_type,
        User userClient,
        UserProfessional userProfessional

){
    public WorkoutPlanDTO(WorkoutPlan data){
        this(data.getId(), data.getName(), data.getWorkout_type()
                ,data.getUserClient(), data.getUserProfessional());
    }
}
