package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.exercise.ExerciseDTO;
import com.sugirotech.healthHub.dtos.exercise.InExerciseDTO;
import com.sugirotech.healthHub.services.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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


    @GetMapping
    @Operation(summary = "Get all exercises!",
            description ="Get all exercises!",
            tags = {"Exercise"})
    public ResponseEntity<List<ExerciseDTO>> getAll (){
        return new ResponseEntity<>(exerciseService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get exercise by ID",
            description ="Get exercise by ID",
            tags = {"Exercise"})
    public ResponseEntity<ExerciseDTO> getByCPF(@PathVariable Long id){
        return new ResponseEntity<>(exerciseService.getById(id), HttpStatus.OK);
    }
}
