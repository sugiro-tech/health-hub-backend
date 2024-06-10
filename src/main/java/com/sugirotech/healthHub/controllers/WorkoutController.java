package com.sugirotech.healthHub.controllers;


import com.sugirotech.healthHub.dtos.workout.InWorkoutDTO;
import com.sugirotech.healthHub.dtos.workout.WorkoutDTO;
import com.sugirotech.healthHub.services.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/workout")
@SecurityRequirement(name = "bearer-key")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping
    @Transactional
    @Operation(summary = "Register an workout!",
            description ="Register an workout!",
            tags = {"Workout"})
    public ResponseEntity<WorkoutDTO> create (@RequestBody @Valid InWorkoutDTO data, UriComponentsBuilder uriBuilder){
        WorkoutDTO workout = workoutService.create(data);

        var uri = uriBuilder.path("/workout/{id}").buildAndExpand(workout.id()).toUri();

        return ResponseEntity.created(uri).body(workout);
    }

    // BUSCAR 'WORKOUT'S' PELO ID DE 'WORKOUT PLAN'

    @GetMapping("/plan/{id}")
    @Operation(summary = "Search Workout by Workout Plan!",
            description ="Search Workout by Workout Plan!",
            tags = {"Workout"})
    public ResponseEntity<List<WorkoutDTO>> getByWorkoutPlan(@PathVariable Long id){
        return new ResponseEntity<>(workoutService.getByWorkoutPlan(id), HttpStatus.OK);
    }
}
