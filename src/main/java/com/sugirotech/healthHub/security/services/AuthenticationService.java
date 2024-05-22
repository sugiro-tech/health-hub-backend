package com.sugirotech.healthHub.security.services;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.security.dtos.AuthenticationDTO;
import com.sugirotech.healthHub.security.dtos.TokenJwtDTO;
import com.sugirotech.healthHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private UserService userService;


    // Verificando o tipo de usuário e retornando o seu token


    public TokenJwtDTO loginAndCreateToken(AuthenticationDTO data) {

        if (userService.isClient(data.email())) {
            String tokenJWT = tokenService.gerarToken((User) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal());

            return new TokenJwtDTO(tokenJWT);
        }
        String tokenJWT = tokenService.gerarTokenProfessional((UserProfessional) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal());

        return new TokenJwtDTO(tokenJWT);
    }
}
