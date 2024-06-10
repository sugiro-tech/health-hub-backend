package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.nutri.InNutriDTO;
import com.sugirotech.healthHub.dtos.nutri.NutriDTO;
import com.sugirotech.healthHub.services.InfoNutriService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/nutri")
@SecurityRequirement(name = "bearer-key")

public class InfoNutriController {

    @Autowired
    private InfoNutriService nutriService;

    @PreAuthorize("hasRole('ADMIN') or hasRole('PROFESSIONAL')")
    @PostMapping
    @Transactional
    @Operation(summary = "Register a nutritional table!",
            description ="Register a nutritional table!",
            tags = {"Nutritional"})
    public ResponseEntity<NutriDTO> create (@RequestBody @Valid InNutriDTO data, UriComponentsBuilder uriBuilder){
        NutriDTO nutri = nutriService.create(data);

        var uri = uriBuilder.path("/nutri/{id}").buildAndExpand(nutri.id()).toUri();

        return ResponseEntity.created(uri).body(nutri);
    }
}
