package com.sugirotech.healthHub.controllers;


import com.sugirotech.healthHub.dtos.Workout.InWorkoutDTO;
import com.sugirotech.healthHub.dtos.Workout.WorkoutDTO;
import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.services.WorkoutService;
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
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;


    @PostMapping
    @Transactional
    @Operation(summary = "Register an workout!",
            description ="Register an workout!",
            tags = {"Workout"})
    public ResponseEntity<WorkoutDTO> create (@RequestBody @Valid InWorkoutDTO data, UriComponentsBuilder uriBuilder){
        Workout workout = new Workout(data);

        var uri = uriBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();

        return ResponseEntity.created(uri).body(workoutService.create(data));
    }
}
