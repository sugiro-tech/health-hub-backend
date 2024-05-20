package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.exercise.ExerciseDTO;
import com.sugirotech.healthHub.dtos.exercise.InExerciseDTO;
import com.sugirotech.healthHub.services.ExerciseService;
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
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping
    @Transactional
    @Operation(summary = "Register an exercise!",
            description ="Register an exercise!",
            tags = {"Exercise"})
    public ResponseEntity<ExerciseDTO> create (@RequestBody @Valid InExerciseDTO data, UriComponentsBuilder uriBuilder){
        ExerciseDTO exercise = exerciseService.create(data);

        var uri = uriBuilder.path("/exercise/{id}").buildAndExpand(exercise.id()).toUri();

        return ResponseEntity.created(uri).body(exercise);
    }
}
