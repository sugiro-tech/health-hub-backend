package com.sugirotech.healthHub.dtos.exercise;

import jakarta.validation.constraints.*;

public record InExerciseDTO(
        @NotBlank
        @Size(max = 100)
        String name,
        @Positive
        Integer rounds,
        @Positive
        Integer repetitions,
        @PositiveOrZero
        Double exercise_interval,
        @PositiveOrZero
        Double interval_next,
        @Positive
        Long workoutID
) {
}
