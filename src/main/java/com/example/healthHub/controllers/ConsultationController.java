package com.example.healthHub.controllers;

import com.example.healthHub.dtos.ConsultationDto;
import com.example.healthHub.models.ConsultationModel;
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
public class ConsultationController {
    @Autowired
    ConsultationRepository consultationRepository;
    @Autowired
    InfoNutritionalRepository infoNutritionalRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserClientRepository userClientRepository;
    @Autowired
    ServicesRepository servicesRepository;
    @PostMapping("/consultation")
    public ResponseEntity<Object> saveConsultation(@RequestBody ConsultationDto consultationDto){
        ConsultationModel newConsultation = new ConsultationModel();

        if(consultationDto.date() != null){
            newConsultation.setDate(consultationDto.date());
        }
        if(consultationDto.status() != null){
            newConsultation.setStatus(consultationDto.status());
        }
        if(consultationDto.duration() != null){
            newConsultation.setDuration(consultationDto.duration());
        }
        if(consultationDto.fk_address() != null){
            newConsultation.setFk_address(addressRepository.findById(consultationDto.fk_address()).get());
        }
        if(consultationDto.fk_client() != null){
            newConsultation.setFk_client(userClientRepository.findById(consultationDto.fk_client()).get());
        }
        if(consultationDto.fk_service() != null){
            newConsultation.setFk_service(servicesRepository.findById(consultationDto.fk_service()).get());
        }
        newConsultation.setOnline(consultationDto.isOnline());

        return ResponseEntity.status(HttpStatus.CREATED).body(consultationRepository.save(newConsultation));
    }

    @GetMapping("/consultation")
    public ResponseEntity<Object> getAllConsultation(){
        List<ConsultationModel> listConsultations = consultationRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listConsultations);
    }

    @GetMapping("/consultation/{id}")
    public ResponseEntity<Object> getOneConsultation(@RequestParam("id") int id){
        Optional<ConsultationModel> consultationReturn = consultationRepository.findById(id);

        if(consultationReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(consultationReturn.get());
    }
    @PutMapping("/consultation")
    public ResponseEntity<Object> updateConsultation(@RequestParam("id") int id,
                                              @RequestBody ConsultationDto consultationDto)
    {
        Optional<ConsultationModel> updatedConsultation = consultationRepository.findById(id);


        if(updatedConsultation.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(consultationDto.date() != null){
            updatedConsultation.get().setDate(consultationDto.date());
        }
        if(consultationDto.status() != null){
            updatedConsultation.get().setStatus(consultationDto.status());
        }
        if(consultationDto.duration() != null){
            updatedConsultation.get().setDuration(consultationDto.duration());
        }
        if(consultationDto.fk_address() != null){
            updatedConsultation.get().setFk_address(addressRepository.findById(consultationDto.fk_address()).get());
        }
        if(consultationDto.fk_client() != null){
            updatedConsultation.get().setFk_client(userClientRepository.findById(consultationDto.fk_client()).get());
        }
        if(consultationDto.fk_service() != null){
            updatedConsultation.get().setFk_service(servicesRepository.findById(consultationDto.fk_service()).get());
        }
        updatedConsultation.get().setOnline(consultationDto.isOnline());

        return ResponseEntity.status(HttpStatus.OK).body(updatedConsultation);
    }

    @DeleteMapping("/consultation")
    public ResponseEntity<Object> deleteConsultation(@RequestParam("id") int id){
        Optional<ConsultationModel> deleteConsultation = consultationRepository.findById(id);

        if(deleteConsultation.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        consultationRepository.delete(deleteConsultation.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
