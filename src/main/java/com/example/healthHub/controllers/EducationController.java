package com.example.healthHub.controllers;

import com.example.healthHub.dtos.EducationDto;
import com.example.healthHub.models.EducationModel;
import com.example.healthHub.repositories.ChartRepository;
import com.example.healthHub.repositories.EducationRepository;
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
public class EducationController {
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;

    @PostMapping("/education")
    public ResponseEntity<Object> saveEducation(@RequestBody EducationDto educationDto){
        EducationModel newEducation = new EducationModel();

        if(educationDto.course() != null){
            newEducation.setCourse(educationDto.course());
        }
        if(educationDto.experience() != null){
            newEducation.setExperience(educationDto.experience());
        }
        if(educationDto.university() != null){
            newEducation.setUniversity(educationDto.university());
        }
        if(educationDto.fk_professional() != null){
            newEducation.setFk_professional(userProfessionalRepository.findById(educationDto.fk_professional()).get());
        }


        return ResponseEntity.status(HttpStatus.CREATED).body(educationRepository.save(newEducation));
    }

    @GetMapping("/education")
    public ResponseEntity<Object> getAllEducation(){
        List<EducationModel> listEducations = educationRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listEducations);
    }

    @GetMapping("/education/{id}")
    public ResponseEntity<Object> getOneEducation(@RequestParam("id") int id){
        Optional<EducationModel> educationReturn = educationRepository.findById(id);

        if(educationReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(educationReturn.get());
    }
    @PutMapping("/education")
    public ResponseEntity<Object> updateEducation(@RequestParam("id") int id,
                                              @RequestBody EducationDto educationDto)
    {
        Optional<EducationModel> updatedEducation = educationRepository.findById(id);


        if(updatedEducation.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(educationDto.course() != null){
            updatedEducation.get().setCourse(educationDto.course());
        }
        if(educationDto.experience() != null){
            updatedEducation.get().setExperience(educationDto.experience());
        }
        if(educationDto.university() != null){
            updatedEducation.get().setUniversity(educationDto.university());
        }
        if(educationDto.fk_professional() != null){
            updatedEducation.get().setFk_professional(userProfessionalRepository.findById(educationDto.fk_professional()).get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedEducation);
    }

    @DeleteMapping("/education")
    public ResponseEntity<Object> deleteEducation(@RequestParam("id") int id){
        Optional<EducationModel> deleteEducation = educationRepository.findById(id);

        if(deleteEducation.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        educationRepository.delete(deleteEducation.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
