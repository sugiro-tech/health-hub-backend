package com.sugirotech.healthHub.dtos.users;

import com.sugirotech.healthHub.enums.users.EnumJobProfessional;
import com.sugirotech.healthHub.enums.users.EnumSex;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

// DTO para Input de Profissional

public record InUserProfessionalDTO(
        @NotBlank
        @Size(max = 100)
        String name,

        @Email(message = "Email should be valid")
        String email,

        @NotBlank
        @Size(min = 6, max = 30)
        String password,

        @NotBlank
        @Size(min = 11, max = 11)
        String cpf,

        @Min(13)
        Integer age,

        @Enumerated
        EnumSex sex,

        @NotBlank
        String crn_cref,

        @Enumerated
        EnumJobProfessional job
){
}
