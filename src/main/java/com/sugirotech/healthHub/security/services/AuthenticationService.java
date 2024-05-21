package com.sugirotech.healthHub.security.services;

import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.security.dtos.AuthenticationDTO;
import com.sugirotech.healthHub.security.dtos.TokenJwtDTO;
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

    public TokenJwtDTO loginAndCreateToken(AuthenticationDTO data){
        String tokenJWT = tokenService.gerarToken((User) manager.authenticate(new UsernamePasswordAuthenticationToken(data.email(), data.senha())).getPrincipal());

        return new TokenJwtDTO(tokenJWT);
    }
}
