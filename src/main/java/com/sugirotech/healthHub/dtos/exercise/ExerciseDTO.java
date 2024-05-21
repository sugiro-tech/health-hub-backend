package com.sugirotech.healthHub.dtos.exercise;

import com.sugirotech.healthHub.entities.Exercise;

public record ExerciseDTO(
    Long id,
    String name,
    Integer rounds,
    Integer repetitions,
    Double exercise_interval,
    Double interval_next,
    Long workoutID
) {
    public ExerciseDTO(Exercise exercise){
        this(exercise.getId(), exercise.getName(), exercise.getRounds(),
                exercise.getRepetitions(), exercise.getExercise_interval(),
                exercise.getInterval_next(), exercise.getWorkout().getId());
    }
}
