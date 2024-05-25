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
        System.out.println("Service: loginAndCreateToken called with data: " + data);

        if (userService.isClient(data.email())) {
            System.out.println("Service: User is client");
            try {
                User user = (User) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal();
                System.out.println("Service: User authenticated: " + user.getEmail());
                String tokenJWT = tokenService.gerarToken(user);
                System.out.println("Service: Token generated for client: " + tokenJWT);
                return new TokenJwtDTO(tokenJWT);
            } catch (Exception e) {
                System.out.println("Service: Exception during client authentication: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        } else {
            System.out.println("Service: User is professional");
            try {
                UserProfessional userProfessional = (UserProfessional) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal();
                System.out.println("Service: UserProfessional authenticated: " + userProfessional.getEmail());
                String tokenJWT = tokenService.gerarTokenProfessional(userProfessional);
                System.out.println("Service: Token generated for professional: " + tokenJWT);
                return new TokenJwtDTO(tokenJWT);
            } catch (Exception e) {
                System.out.println("Service: Exception during professional authentication: " + e.getMessage());
                e.printStackTrace();
                throw e;
            }
        }
    }
    }
