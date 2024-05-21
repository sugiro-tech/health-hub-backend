package com.sugirotech.healthHub.dtos.workout;


import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.enums.workout.EnumWeekdays;


public record WorkoutDTO(
        Long id,
        String name,
        EnumWeekdays weekday
) {
    public WorkoutDTO(Workout workout) {
        this(workout.getId(), workout.getName(),
                workout.getWeekday());
    }
}
