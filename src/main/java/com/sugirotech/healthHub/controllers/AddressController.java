package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.address.AddressDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/address")
@SecurityRequirement(name = "bearer-key")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    @Transactional
    @Operation(summary = "Register an address!",
            description ="Register an address!",
            tags = {"Address"})
    public ResponseEntity<AddressDTO> create (@RequestBody @Valid InAddressDTO data, UriComponentsBuilder uriBuilder){
        AddressDTO address = addressService.create(data);
        var uri = uriBuilder.path("/address/{id}").buildAndExpand(address.id()).toUri();

        return ResponseEntity.created(uri).body(address);
    }

    @GetMapping
    @Operation(summary = "Get all addresses!",
            description ="Get all addresses!",
            tags = {"Address"})
    public ResponseEntity<List<AddressDTO>> getAll (){



        return new ResponseEntity<>(addressService.getAll(), HttpStatus.OK);
    }
}
