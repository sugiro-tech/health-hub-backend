package com.sugirotech.healthHub.dtos.users;

import com.sugirotech.healthHub.enums.users.EnumJobProfessional;
import com.sugirotech.healthHub.enums.users.EnumSex;

public record UserProfessionalDTO(

        Long id,
        String name,
        String email,
        String cpf,
        Integer age,
        EnumSex sex,
        Integer rating,
        EnumJobProfessional job,
        String crn_cref
){
}
