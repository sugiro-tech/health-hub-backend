package com.example.healthHub.controllers;

import com.example.healthHub.dtos.ServicesDto;
import com.example.healthHub.models.ServicesModel;
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
public class ServicesController {
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;
    @PostMapping("/services")
    public ResponseEntity<Object> saveServices(@RequestBody ServicesDto servicesDto){
        ServicesModel newServices = new ServicesModel();

        if(servicesDto.fk_professional() != null){
            newServices.setFk_professional(userProfessionalRepository.findById(servicesDto.fk_professional()).get());
        }
        if(servicesDto.price() != null){
            newServices.setPrice(servicesDto.price());
        }
        if(servicesDto.name() != null){
            newServices.setName(servicesDto.name());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(servicesRepository.save(newServices));
    }

    @GetMapping("/services")
    public ResponseEntity<Object> getAllServices(){
        List<ServicesModel> listServicess = servicesRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listServicess);
    }

    @GetMapping("/services/{id}")
    public ResponseEntity<Object> getOneServices(@RequestParam("id") int id){
        Optional<ServicesModel> servicesReturn = servicesRepository.findById(id);

        if(servicesReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(servicesReturn.get());
    }
    @PutMapping("/services")
    public ResponseEntity<Object> updateServices(@RequestParam("id") int id,
                                              @RequestBody ServicesDto servicesDto)
    {
        Optional<ServicesModel> updatedServices = servicesRepository.findById(id);


        if(updatedServices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(servicesDto.fk_professional() != null){
            updatedServices.get().setFk_professional(userProfessionalRepository.findById(servicesDto.fk_professional()).get());
        }
        if(servicesDto.price() != null){
            updatedServices.get().setPrice(servicesDto.price());
        }
        if(servicesDto.name() != null){
            updatedServices.get().setName(servicesDto.name());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedServices);
    }

    @DeleteMapping("/services")
    public ResponseEntity<Object> deleteServices(@RequestParam("id") int id){
        Optional<ServicesModel> deleteServices = servicesRepository.findById(id);

        if(deleteServices.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        servicesRepository.delete(deleteServices.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
