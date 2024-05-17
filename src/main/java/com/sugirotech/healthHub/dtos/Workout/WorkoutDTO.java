package com.sugirotech.healthHub.dtos.Workout;


import com.sugirotech.healthHub.entities.Exercise;
import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.enums.workout.EnumWeekdays;


import java.util.List;

public record WorkoutDTO(
        Long id,
        String name,
        EnumWeekdays weekday,
        List<Exercise> exercises
) {
    public WorkoutDTO(Workout workout) {
        this(workout.getId(), workout.getName(),
                workout.getWeekday(), workout.getExercises());
    }
}
