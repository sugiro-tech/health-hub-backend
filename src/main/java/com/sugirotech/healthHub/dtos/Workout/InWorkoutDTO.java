package com.sugirotech.healthHub.dtos.Workout;


import com.sugirotech.healthHub.enums.workout.EnumWeekdays;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record InWorkoutDTO(
        @NotBlank
        String name,
        @Enumerated
        EnumWeekdays weekday,

        List<Long> exerciseIds
        
) {
}
