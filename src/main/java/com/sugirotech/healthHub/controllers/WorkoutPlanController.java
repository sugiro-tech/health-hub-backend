package com.sugirotech.healthHub.controllers;

import com.sugirotech.healthHub.dtos.workoutplan.InWorkoutPlanDTO;
import com.sugirotech.healthHub.dtos.workoutplan.WorkoutPlanDTO;
import com.sugirotech.healthHub.services.WorkoutPlanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/workout_plan")
@SecurityRequirement(name = "bearer-key")
public class WorkoutPlanController {

    @Autowired
    private WorkoutPlanService workoutPlanService;

    @PostMapping
    @Transactional
    @Operation(summary = "Register an workout plan!",
            description ="Register an workout plan!",
            tags = {"Workout Plan"})
    public ResponseEntity<WorkoutPlanDTO> create(@RequestBody @Valid InWorkoutPlanDTO data, UriComponentsBuilder uriBuilder){
        WorkoutPlanDTO workoutPlan= workoutPlanService.create(data);

        var uri = uriBuilder.path("/workout/{id}").buildAndExpand(workoutPlan.id()).toUri();

        return ResponseEntity.created(uri).body(workoutPlan);
    }
}
