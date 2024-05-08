package com.example.healthHub.controllers;

import com.example.healthHub.dtos.DietDto;
import com.example.healthHub.models.DietModel;
import com.example.healthHub.repositories.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class DietController {
    @Autowired
    DietRepository dietRepository;
    @Autowired
    InfoNutritionalRepository infoNutritionalRepository;
    @Autowired
    DietPlanRepository dietPlanRepository;
    @PostMapping("/diet")
    public ResponseEntity<Object> saveDiet(@RequestBody DietDto dietDto){
        DietModel newDiet = new DietModel();

        if(dietDto.category() != null){
            newDiet.setCategory(dietDto.category());
        }
        if(dietDto.food() != null){
            newDiet.setFood(dietDto.food());
        }
        if(dietDto.quantity() != null){
            newDiet.setQuantity(dietDto.quantity());
        }
        if(dietDto.schedule() != null){
            newDiet.setSchedule(dietDto.schedule());
        }
        if(dietDto.title() != null){
            newDiet.setTitle(dietDto.title());
        }
        if(dietDto.unit() != null){
            newDiet.setUnit(dietDto.unit());
        }
        if(dietDto.fk_info() != null){
            newDiet.setFk_info(infoNutritionalRepository.findById(dietDto.fk_info()).get());
        }
        if(dietDto.fk_plan() != null){
            newDiet.setFk_plan(dietPlanRepository.findById(dietDto.fk_plan()).get());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(dietRepository.save(newDiet));
    }

    @GetMapping("/diet")
    public ResponseEntity<Object> getAllDiet(){
        List<DietModel> listDiets = dietRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listDiets);
    }

    @GetMapping("/diet/{id}")
    public ResponseEntity<Object> getOneDiet(@RequestParam("id") int id){
        Optional<DietModel> dietReturn = dietRepository.findById(id);

        if(dietReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(dietReturn.get());
    }
    @PutMapping("/diet")
    public ResponseEntity<Object> updateDiet(@RequestParam("id") int id,
                                              @RequestBody DietDto dietDto)
    {
        Optional<DietModel> updatedDiet = dietRepository.findById(id);


        if(updatedDiet.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(dietDto.category() != null){
            updatedDiet.get().setCategory(dietDto.category());
        }
        if(dietDto.food() != null){
            updatedDiet.get().setFood(dietDto.food());
        }
        if(dietDto.quantity() != null){
            updatedDiet.get().setQuantity(dietDto.quantity());
        }
        if(dietDto.schedule() != null){
            updatedDiet.get().setSchedule(dietDto.schedule());
        }
        if(dietDto.title() != null){
            updatedDiet.get().setTitle(dietDto.title());
        }
        if(dietDto.unit() != null){
            updatedDiet.get().setUnit(dietDto.unit());
        }
        if(dietDto.fk_info() != null){
            updatedDiet.get().setFk_info(infoNutritionalRepository.findById(dietDto.fk_info()).get());
        }
        if(dietDto.fk_plan() != null){
            updatedDiet.get().setFk_plan(dietPlanRepository.findById(dietDto.fk_plan()).get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedDiet);
    }

    @DeleteMapping("/diet")
    public ResponseEntity<Object> deleteDiet(@RequestParam("id") int id){
        Optional<DietModel> deleteDiet = dietRepository.findById(id);

        if(deleteDiet.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        dietRepository.delete(deleteDiet.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
