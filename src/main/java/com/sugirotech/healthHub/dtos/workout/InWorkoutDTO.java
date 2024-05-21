package com.sugirotech.healthHub.dtos.workout;

import com.sugirotech.healthHub.enums.workout.EnumWeekdays;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record InWorkoutDTO(
        @NotBlank
        String name,
        @Enumerated
        EnumWeekdays weekday,
        @Positive
        Long workoutPlanId
) {
}
