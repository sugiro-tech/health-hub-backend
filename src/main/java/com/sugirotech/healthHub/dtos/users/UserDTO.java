package com.sugirotech.healthHub.dtos.users;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.enums.users.EnumSex;

public record UserDTO(
        Long id,
        String name,
        String email,
        String cpf,
        Integer age,
        EnumSex sex
){
    public UserDTO(User usuario) {
        this(usuario.getId(), usuario.getName(), usuario.getEmail(),
                usuario.getCpf(), usuario.getAge(), usuario.getSex());
    }
}
