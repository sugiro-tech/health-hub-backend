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

        System.out.println(userService.isClient(data.email()));

        if (userService.isClient(data.email())) {
            System.out.println("Entrou!");

            String tokenJWT = tokenService.gerarToken((User) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal());
            System.out.println("Token - " + tokenJWT);

            return new TokenJwtDTO(tokenJWT);
        }
        else {
            System.out.println("Entrou else!");
            String tokenJWT = tokenService.gerarTokenProfessional((UserProfessional) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal());
            System.out.println("Token - " + tokenJWT);

            return new TokenJwtDTO(tokenJWT);
        }
    }
}
