package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.InNutriDTO;
import com.sugirotech.healthHub.entities.InfoNutri;
import com.sugirotech.healthHub.services.InfoNutriService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/nutri")
public class InfoNutriController {

    @Autowired
    private InfoNutriService nutriService;

    @PostMapping
    @Transactional
    @Operation(summary = "Register a nutritional table!",
            description ="Register a nutritional table!",
            tags = {"Nutritional Info"})
    public ResponseEntity<InNutriDTO> create (@RequestBody @Valid InNutriDTO data, UriComponentsBuilder uriBuilder){
        InfoNutri nutri = new InfoNutri(data);

        var uri = uriBuilder.path("/exercise/{id}").buildAndExpand(nutri.getId()).toUri();

        // Terminar

        return ResponseEntity.created(uri).body(new InNutriDTO(nutri));
    }
}
