package com.sugirotech.healthHub.security.services;

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

//    public OutUsuarioDTO register(InUsuarioDTO dados){
//
//        Usuario usuario = new Usuario(dados, passwordEncoder.encode(dados.senha()));
//
//        System.out.println("ROLES - " + usuario.getAuthorities());
//
//        usuarioService.save(usuario);
//
//        return new OutUsuarioDTO(usuario);
//    }
}
