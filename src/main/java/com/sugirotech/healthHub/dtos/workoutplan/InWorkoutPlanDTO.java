package com.sugirotech.healthHub.dtos.workoutplan;

import com.sugirotech.healthHub.enums.workout.EnumWorkoutType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record InWorkoutPlanDTO(
        @NotBlank
        String name,
        @Enumerated
        EnumWorkoutType workout_type,
        @Positive
        Long userClientId,
        @Positive
        Long userProfessionalId
){
}
