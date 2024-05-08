package com.example.healthHub.dtos;

import com.example.healthHub.models.AddressModel;
import com.example.healthHub.models.UserClientModel;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public record UserClientDto(
        String name,
        UserClientModel.Sexo gender,
        Integer age,
        Integer fk_address,
        String email,
        String password

) {
}
