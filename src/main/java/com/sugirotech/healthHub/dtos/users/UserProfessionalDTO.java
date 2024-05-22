package com.sugirotech.healthHub.dtos.users;

import com.sugirotech.healthHub.entities.users.UserProfessional;
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
    public UserProfessionalDTO(UserProfessional usuario) {
        this(usuario.getId(), usuario.getName(), usuario.getEmail(),
                usuario.getCpf(), usuario.getAge(), usuario.getSex(),
                usuario.getRating(), usuario.getJob(), usuario.getCrn_cref());
    }
}
