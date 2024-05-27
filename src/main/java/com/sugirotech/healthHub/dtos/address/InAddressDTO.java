package com.sugirotech.healthHub.dtos.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record InAddressDTO(
        @NotBlank
        String name,
        @NotBlank
        String street,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @Positive
        Integer number,
        @Positive
        String email_user
) {
}
