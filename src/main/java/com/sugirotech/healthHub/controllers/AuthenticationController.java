package com.sugirotech.healthHub.controllers;


import com.sugirotech.healthHub.dtos.users.InUserDTO;
import com.sugirotech.healthHub.dtos.users.InUserProfessionalDTO;
import com.sugirotech.healthHub.dtos.users.UserDTO;
import com.sugirotech.healthHub.dtos.users.UserProfessionalDTO;
import com.sugirotech.healthHub.security.dtos.AuthenticationDTO;
import com.sugirotech.healthHub.security.dtos.TokenJwtDTO;
import com.sugirotech.healthHub.security.services.AuthenticationService;
import com.sugirotech.healthHub.security.services.AuthorizationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AuthorizationService authorizationService;


    @PostMapping
    @Operation(summary = "Fazer Login!",
            description ="Fazer Login!",
            tags = {"Auth"})
    public ResponseEntity<TokenJwtDTO> login(@RequestBody @Valid AuthenticationDTO data){
        System.out.println("Print controller - " + authenticationService.loginAndCreateToken(data));

        return new ResponseEntity<>(authenticationService.loginAndCreateToken(data), HttpStatus.OK);
    }

    @PostMapping("/register/professional")
    @Operation(summary = "Register a professional!",
            description ="Register a professional!!",
            tags = {"Auth"})
    public ResponseEntity<UserProfessionalDTO> registerProfessional(@RequestBody @Valid InUserProfessionalDTO dados){
        return new ResponseEntity<>(authorizationService.register(dados), HttpStatus.OK);
    }


    @PostMapping("/register/client")
    @Operation(summary = "Register a client!",
            description ="Register a client!",
            tags = {"Auth"})
    public ResponseEntity<UserDTO> registerClient(@RequestBody @Valid InUserDTO dados){
        return new ResponseEntity<>(authorizationService.register(dados), HttpStatus.OK);
    }
}
