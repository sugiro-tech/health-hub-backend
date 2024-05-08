package com.example.healthHub.dtos;

import com.example.healthHub.models.ConsultationModel;

import java.util.Date;

public record ServicesDto(
        Integer fk_professional,
        Double price,
        String name
) {
}
