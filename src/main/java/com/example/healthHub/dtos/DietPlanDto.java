package com.example.healthHub.dtos;

import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record DietPlanDto(
        Integer fk_professional,
        Integer fk_client
) {
}
