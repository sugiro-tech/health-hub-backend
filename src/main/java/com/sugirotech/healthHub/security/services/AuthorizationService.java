package com.sugirotech.healthHub.security.services;

import com.sugirotech.healthHub.dtos.users.InUserDTO;
import com.sugirotech.healthHub.dtos.users.InUserProfessionalDTO;
import com.sugirotech.healthHub.dtos.users.UserDTO;
import com.sugirotech.healthHub.dtos.users.UserProfessionalDTO;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthorizationService {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Fazer registro

    public UserProfessionalDTO registerProfessional(InUserProfessionalDTO dados){

        UserProfessional usuario = new UserProfessional(dados, passwordEncoder.encode(dados.password()));

        System.out.println("ROLES - " + usuario.getAuthorities());
        System.out.println("Usuario - " + usuario.getName());

        userService.saveProfessional(usuario);

        return new UserProfessionalDTO(usuario);
    }

    // Client

    public UserDTO registerClient(InUserDTO dados){

        User usuario = new User(dados, passwordEncoder.encode(dados.password()));

        System.out.println("ROLES - " + usuario.getAuthorities());
        userService.saveClient(usuario);

        return new UserDTO(usuario);
    }

}
