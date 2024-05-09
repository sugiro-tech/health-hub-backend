package com.sugirotech.healthHub.dtos;

import com.sugirotech.healthHub.entities.Exercise;
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
        Double interval_next
) {
    public InExerciseDTO(Exercise exercise) {
        this(exercise.getName(), exercise.getRounds(),
                exercise.getRepetitions(), exercise.getExercise_interval(),
                exercise.getInterval_next());
    }
}
