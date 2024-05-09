package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.InfoNutriDTO;
import com.sugirotech.healthHub.services.InfoNutriService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<InfoNutriDTO> create (@RequestBody @Valid InfoNutriDTO data, UriComponentsBuilder uriBuilder){
        InfoNutriDTO nutri = nutriService.create(data);

        // Terminar

        return  nutri;
    }

}
