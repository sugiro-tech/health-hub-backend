package com.example.healthHub.controllers;

import com.example.healthHub.dtos.InfoNutritionalDto;
import com.example.healthHub.models.InfoNutritionalModel;
import com.example.healthHub.repositories.InfoNutritionalRepository;
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
public class InfoNutritionalController {
    @Autowired
    InfoNutritionalRepository infoNutritionalRepository;
    @Autowired
    UserClientRepository userClientRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;

    @PostMapping("/infoNutritional")
    public ResponseEntity<Object> saveInfoNutritional(@RequestBody InfoNutritionalDto infoNutritionalDto){
        InfoNutritionalModel newInfoNutritional = new InfoNutritionalModel();

        if(infoNutritionalDto.cho() != null){
            newInfoNutritional.setCho(infoNutritionalDto.cho());
        }
        if(infoNutritionalDto.fibers() != null){
            newInfoNutritional.setFibers(infoNutritionalDto.fibers());
        }
        if(infoNutritionalDto.kcal() != null){
            newInfoNutritional.setKcal(infoNutritionalDto.kcal());
        }
        if(infoNutritionalDto.ptn() != null){
            newInfoNutritional.setPtn(infoNutritionalDto.ptn());
        }
        if(infoNutritionalDto.lip() != null){
            newInfoNutritional.setLip(infoNutritionalDto.lip());
        }
        if(infoNutritionalDto.sat() != null){
            newInfoNutritional.setSat(infoNutritionalDto.sat());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(infoNutritionalRepository.save(newInfoNutritional));
    }

    @GetMapping("/infoNutritional")
    public ResponseEntity<Object> getAllInfoNutritional(){
        List<InfoNutritionalModel> listInfoNutritionals = infoNutritionalRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listInfoNutritionals);
    }

    @GetMapping("/infoNutritional/{id}")
    public ResponseEntity<Object> getOneInfoNutritional(@RequestParam("id") int id){
        Optional<InfoNutritionalModel> infoNutritionalReturn = infoNutritionalRepository.findById(id);

        if(infoNutritionalReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(infoNutritionalReturn.get());
    }
    @PutMapping("/infoNutritional")
    public ResponseEntity<Object> updateInfoNutritional(@RequestParam("id") int id,
                                              @RequestBody InfoNutritionalDto infoNutritionalDto)
    {
        Optional<InfoNutritionalModel> updatedInfoNutritional = infoNutritionalRepository.findById(id);


        if(updatedInfoNutritional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(infoNutritionalDto.cho() != null){
            updatedInfoNutritional.get().setCho(infoNutritionalDto.cho());
        }
        if(infoNutritionalDto.fibers() != null){
            updatedInfoNutritional.get().setFibers(infoNutritionalDto.fibers());
        }
        if(infoNutritionalDto.kcal() != null){
            updatedInfoNutritional.get().setKcal(infoNutritionalDto.kcal());
        }
        if(infoNutritionalDto.ptn() != null){
            updatedInfoNutritional.get().setPtn(infoNutritionalDto.ptn());
        }
        if(infoNutritionalDto.lip() != null){
            updatedInfoNutritional.get().setLip(infoNutritionalDto.lip());
        }
        if(infoNutritionalDto.sat() != null){
            updatedInfoNutritional.get().setSat(infoNutritionalDto.sat());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedInfoNutritional);
    }

    @DeleteMapping("/infoNutritional")
    public ResponseEntity<Object> deleteInfoNutritional(@RequestParam("id") int id){
        Optional<InfoNutritionalModel> deleteInfoNutritional = infoNutritionalRepository.findById(id);

        if(deleteInfoNutritional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        infoNutritionalRepository.delete(deleteInfoNutritional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
