package com.sugirotech.healthHub.dtos.users;

import com.sugirotech.healthHub.enums.users.EnumSex;

public record UserDTO(
        Long id,
        String name,
        String email,
        String cpf,
        Integer age,
        EnumSex sex
){
}
