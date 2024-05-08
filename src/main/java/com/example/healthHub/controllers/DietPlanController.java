package com.example.healthHub.controllers;

import com.example.healthHub.dtos.DietPlanDto;
import com.example.healthHub.models.DietPlanModel;
import com.example.healthHub.repositories.DietPlanRepository;
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
public class DietPlanController {
    @Autowired
    DietPlanRepository dietPlanRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;
    @Autowired
    UserClientRepository userClientRepository;
    @PostMapping("/dietPlan")
    public ResponseEntity<Object> saveDietPlan(@RequestBody DietPlanDto dietPlanDto){
        DietPlanModel newDietPlan = new DietPlanModel();

        if(dietPlanDto.fk_client() != null){
            newDietPlan.setFk_client(userClientRepository.findById(dietPlanDto.fk_client()).get());
        }
        if(dietPlanDto.fk_professional() != null){
            newDietPlan.setFk_professional(userProfessionalRepository.findById(dietPlanDto.fk_professional()).get());
        }
      

        return ResponseEntity.status(HttpStatus.CREATED).body(dietPlanRepository.save(newDietPlan));
    }

    @GetMapping("/dietPlan")
    public ResponseEntity<Object> getAllDietPlan(){
        List<DietPlanModel> listDietPlans = dietPlanRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listDietPlans);
    }

    @GetMapping("/dietPlan/{id}")
    public ResponseEntity<Object> getOneDietPlan(@RequestParam("id") int id){
        Optional<DietPlanModel> dietPlanReturn = dietPlanRepository.findById(id);

        if(dietPlanReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(dietPlanReturn.get());
    }
    @PutMapping("/dietPlan")
    public ResponseEntity<Object> updateDietPlan(@RequestParam("id") int id,
                                              @RequestBody DietPlanDto dietPlanDto)
    {
        Optional<DietPlanModel> updatedDietPlan = dietPlanRepository.findById(id);


        if(updatedDietPlan.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(dietPlanDto.fk_client() != null){
            updatedDietPlan.get().setFk_client(userClientRepository.findById(dietPlanDto.fk_client()).get());
        }
        if(dietPlanDto.fk_professional() != null){
            updatedDietPlan.get().setFk_professional(userProfessionalRepository.findById(dietPlanDto.fk_professional()).get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedDietPlan);
    }

    @DeleteMapping("/dietPlan")
    public ResponseEntity<Object> deleteDietPlan(@RequestParam("id") int id){
        Optional<DietPlanModel> deleteDietPlan = dietPlanRepository.findById(id);

        if(deleteDietPlan.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        dietPlanRepository.delete(deleteDietPlan.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
