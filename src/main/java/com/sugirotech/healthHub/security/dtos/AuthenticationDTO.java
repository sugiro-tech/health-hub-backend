package com.sugirotech.healthHub.security.dtos;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(

        @NotBlank
        String email,
        @NotBlank
        String senha

){
}
