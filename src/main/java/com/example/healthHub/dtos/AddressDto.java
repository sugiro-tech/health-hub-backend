package com.example.healthHub.dtos;

import com.example.healthHub.models.UserProfessionalModel;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.util.List;

public record AddressDto(
        String name,
        String street,
        String neighborhood,
        String city,
        Integer number,
        String state,
        List<Integer> fk_professional
) {
}
