package com.example.healthHub.dtos;

import com.example.healthHub.models.AddressModel;
import com.example.healthHub.models.ConsultationModel;
import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public record ConsultationDto(
        Integer fk_client,
        Integer fk_service,
        Integer fk_address,
        boolean isOnline,
        Double price,
        Date date,
        ConsultationModel.Status status,
        Double duration
) {
}
