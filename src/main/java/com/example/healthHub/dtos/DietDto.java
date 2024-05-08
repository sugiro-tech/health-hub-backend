package com.example.healthHub.dtos;

import com.example.healthHub.models.DietPlanModel;
import com.example.healthHub.models.InfoNutritionalModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public record DietDto(
        Double schedule,
        String title,
        String food,
        Double quantity,
        String category,
        String unit,
        Integer fk_plan,
        Integer fk_info
) {
}
