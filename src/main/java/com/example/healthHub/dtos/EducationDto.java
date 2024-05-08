package com.example.healthHub.dtos;

import com.example.healthHub.models.UserProfessionalModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record EducationDto(
        String university,
        String course,
        String experience,
        Integer fk_professional
) {
}
