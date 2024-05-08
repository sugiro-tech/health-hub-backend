package com.example.healthHub.controllers;

import com.example.healthHub.dtos.TrainingPlanDto;
import com.example.healthHub.models.TrainingPlanModel;
import com.example.healthHub.repositories.AddressRepository;
import com.example.healthHub.repositories.TrainingPlanRepository;
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
public class TrainingPlanController {
    @Autowired
    TrainingPlanRepository trainingPlanRepository;
    @Autowired
    UserClientRepository userClientRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;

    @PostMapping("/trainingPlan")
    public ResponseEntity<Object> saveTrainingPlan(@RequestBody TrainingPlanDto trainingPlanDto){
        TrainingPlanModel newTrainingPlan = new TrainingPlanModel();

        if(trainingPlanDto.fk_client() != null){
            newTrainingPlan.setFk_client(userClientRepository.findById(trainingPlanDto.fk_client()).get());
        }
        if(trainingPlanDto.fk_professional() != null){
            newTrainingPlan.setFk_professional(userProfessionalRepository.findById(trainingPlanDto.fk_professional()).get());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(trainingPlanRepository.save(newTrainingPlan));
    }

    @GetMapping("/trainingPlan")
    public ResponseEntity<Object> getAllTrainingPlan(){
        List<TrainingPlanModel> listTrainingPlans = trainingPlanRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listTrainingPlans);
    }

    @GetMapping("/trainingPlan/{id}")
    public ResponseEntity<Object> getOneTrainingPlan(@RequestParam("id") int id){
        Optional<TrainingPlanModel> trainingPlanReturn = trainingPlanRepository.findById(id);

        if(trainingPlanReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(trainingPlanReturn.get());
    }
    @PutMapping("/trainingPlan")
    public ResponseEntity<Object> updateTrainingPlan(@RequestParam("id") int id,
                                              @RequestBody TrainingPlanDto trainingPlanDto)
    {
        Optional<TrainingPlanModel> updatedTrainingPlan = trainingPlanRepository.findById(id);


        if(updatedTrainingPlan.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(trainingPlanDto.fk_client() != null){
            updatedTrainingPlan.get().setFk_client(userClientRepository.findById(trainingPlanDto.fk_client()).get());
        }
        if(trainingPlanDto.fk_professional() != null){
            updatedTrainingPlan.get().setFk_professional(userProfessionalRepository.findById(trainingPlanDto.fk_professional()).get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedTrainingPlan);
    }

    @DeleteMapping("/trainingPlan")
    public ResponseEntity<Object> deleteTrainingPlan(@RequestParam("id") int id){
        Optional<TrainingPlanModel> deleteTrainingPlan = trainingPlanRepository.findById(id);

        if(deleteTrainingPlan.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        trainingPlanRepository.delete(deleteTrainingPlan.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
