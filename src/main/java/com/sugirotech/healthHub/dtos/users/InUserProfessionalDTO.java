package com.sugirotech.healthHub.dtos.users;

import com.sugirotech.healthHub.enums.EnumJobProfessional;
import com.sugirotech.healthHub.enums.EnumRoles;
import com.sugirotech.healthHub.enums.EnumSex;
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
        @Size(min = 6)
        String password,

        @NotBlank
        String cpf,

        @NotBlank
        @Min(13)
        Integer age,

        @Enumerated
        EnumSex sex,


        @NotBlank
        String crn_cref,

        @NotBlank
        @Enumerated
        EnumRoles role,

        @Enumerated
        EnumJobProfessional job
){
}
