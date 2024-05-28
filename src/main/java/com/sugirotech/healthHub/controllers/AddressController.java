package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.address.AddressDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    @Transactional
    @Operation(summary = "Register an addrees!",
            description ="Register an addrees!",
            tags = {"Addrees"})
    public ResponseEntity<AddressDTO> create (@RequestBody @Valid InAddressDTO data, UriComponentsBuilder uriBuilder){
        AddressDTO address = addressService.create(data);

        var uri = uriBuilder.path("/address/{id}").buildAndExpand(address.id()).toUri();

        return ResponseEntity.created(uri).body(address);
    }
}
