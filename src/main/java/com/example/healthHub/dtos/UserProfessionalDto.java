package com.example.healthHub.dtos;

import com.example.healthHub.models.AddressModel;
import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;

import java.util.List;

public record UserProfessionalDto(
        String name,
        UserProfessionalModel.Sexo gender,
        String crn_cref,
        String job,
        Double rating,
        List<Integer> fk_address,
        String email,
        String password
) {
}
