package com.example.healthHub.dtos;

import com.example.healthHub.models.ConsultationModel;
import com.example.healthHub.models.TrainingPlanModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public record ChartDto(
        boolean monday,
        boolean tuesday,
        boolean wednesday,
        boolean thursday,
        boolean friday,
        boolean saturday,
        boolean sunday,
        Integer fk_plan
) {
}
