package com.example.healthHub.controllers;

import com.example.healthHub.dtos.ExerciseDto;
import com.example.healthHub.models.ChartModel;
import com.example.healthHub.models.ExerciseModel;
import com.example.healthHub.repositories.ChartRepository;
import com.example.healthHub.repositories.ExerciseRepository;
import com.example.healthHub.repositories.UserClientRepository;
import com.example.healthHub.repositories.UserProfessionalRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class ExerciseController {
    @Autowired
    ExerciseRepository exerciseRepository;
    @Autowired
    ChartRepository chartRepository;

    @PostMapping("/exercise")
    public ResponseEntity<Object> saveExercise(@RequestBody ExerciseDto exerciseDto){
        ExerciseModel newExercise = new ExerciseModel();

        if(exerciseDto.name() != null){
            newExercise.setName(exerciseDto.name());
        }
        if(exerciseDto.exercise_interval() != null){
            newExercise.setExercise_interval(exerciseDto.exercise_interval());
        }
        if(exerciseDto.interval_next() != null){
            newExercise.setInterval_next(exerciseDto.interval_next());
        }
        if(exerciseDto.repetitions() != null){
            newExercise.setRepetitions(exerciseDto.repetitions());
        }
        if(exerciseDto.rounds() != null){
            newExercise.setRounds(exerciseDto.rounds());
        }
        if(exerciseDto.fk_chart() != null){
            newExercise.setFk_chart(chartRepository.findById(exerciseDto.fk_chart()).get());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(exerciseRepository.save(newExercise));
    }

    @GetMapping("/exercise")
    public ResponseEntity<Object> getAllExercise(){
        List<ExerciseModel> listExercises = exerciseRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listExercises);
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<Object> getOneExercise(@RequestParam("id") int id){
        Optional<ExerciseModel> exerciseReturn = exerciseRepository.findById(id);

        if(exerciseReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(exerciseReturn.get());
    }
    @PutMapping("/exercise")
    public ResponseEntity<Object> updateExercise(@RequestParam("id") int id,
                                              @RequestBody ExerciseDto exerciseDto)
    {
        Optional<ExerciseModel> updatedExercise = exerciseRepository.findById(id);


        if(updatedExercise.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(exerciseDto.name() != null){
            updatedExercise.get().setName(exerciseDto.name());
        }
        if(exerciseDto.exercise_interval() != null){
            updatedExercise.get().setExercise_interval(exerciseDto.exercise_interval());
        }
        if(exerciseDto.interval_next() != null){
            updatedExercise.get().setInterval_next(exerciseDto.interval_next());
        }
        if(exerciseDto.repetitions() != null){
            updatedExercise.get().setRepetitions(exerciseDto.repetitions());
        }
        if(exerciseDto.rounds() != null){
            updatedExercise.get().setRounds(exerciseDto.rounds());
        }
        if(exerciseDto.fk_chart() != null){
            updatedExercise.get().setFk_chart(chartRepository.findById(exerciseDto.fk_chart()).get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedExercise);
    }

    @DeleteMapping("/exercise")
    public ResponseEntity<Object> deleteExercise(@RequestParam("id") int id){
        Optional<ExerciseModel> deleteExercise = exerciseRepository.findById(id);

        if(deleteExercise.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        exerciseRepository.delete(deleteExercise.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
