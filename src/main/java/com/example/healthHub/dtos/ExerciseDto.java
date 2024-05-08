package com.example.healthHub.dtos;

import com.example.healthHub.models.ChartModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record ExerciseDto(
        String name,
        Integer rounds,
        Integer repetitions,
        Double exercise_interval,
        Double interval_next,
        Integer fk_chart
) {
}
