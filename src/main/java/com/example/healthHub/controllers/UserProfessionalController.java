package com.example.healthHub.controllers;

import com.example.healthHub.dtos.UserClientDto;
import com.example.healthHub.dtos.UserProfessionalDto;
import com.example.healthHub.infra.security.TokenService;
import com.example.healthHub.models.AddressModel;
import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import com.example.healthHub.repositories.AddressRepository;
import com.example.healthHub.repositories.UserProfessionalRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class UserProfessionalController {
    @Autowired
    UserProfessionalRepository userProfessionalRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;
    @PostMapping("/userProfessional")
    public ResponseEntity<Object> saveUserProfessional(@RequestBody UserProfessionalDto userProfessionalDto){
        UserProfessionalModel newUserProfessional = new UserProfessionalModel();

        if(userProfessionalDto.name() != null){
            newUserProfessional.setName(userProfessionalDto.name());
        }
        if(userProfessionalDto.gender() != null){
            newUserProfessional.setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.job() != null){
            newUserProfessional.setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.crn_cref() != null){
            newUserProfessional.setCrn_cref(userProfessionalDto.crn_cref());
        }
        if(userProfessionalDto.rating() != null){
            newUserProfessional.setRating(userProfessionalDto.rating());
        }
        if(userProfessionalDto.fk_address().size() > 0){
            List<AddressModel> listAddress = new ArrayList<>();
            for (Integer professionalId :
                    userProfessionalDto.fk_address()) {
                listAddress.add(addressRepository.findById(professionalId).get());
            }
            newUserProfessional.setFk_address(listAddress);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userProfessionalRepository.save(newUserProfessional));
    }

    @GetMapping("/userProfessional")
    public ResponseEntity<Object> getAllUserProfessional(){
        List<UserProfessionalModel> listUserProfessionals = userProfessionalRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUserProfessionals);
    }
    @PostMapping("/userProfessional/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserProfessionalDto userProfessionalDto){
        try {
            var usernamePassword = new UsernamePasswordAuthenticationToken(userProfessionalDto.email(), userProfessionalDto.password());
            var auth = this.authenticationManager.authenticate(usernamePassword);

            var token = tokenService.generateTokenProfessional((UserProfessionalModel) auth.getPrincipal());
            return ResponseEntity.status(HttpStatus.OK).body(token);
        }catch (StackOverflowError e){
            throw e;
        }
    }
    @PostMapping("userProfessional/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserProfessionalDto userProfessionalDto){
        if(userProfessionalRepository.findByEmailExists(userProfessionalDto.email()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(userProfessionalDto.password());
        UserProfessionalModel newUserProfessional = new UserProfessionalModel();

        if(userProfessionalDto.name() != null){
            newUserProfessional.setName(userProfessionalDto.name());
        }
        if(userProfessionalDto.email() != null){
            newUserProfessional.setEmail(userProfessionalDto.email());
        }
        if(userProfessionalDto.gender() != null){
            newUserProfessional.setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.job() != null){
            newUserProfessional.setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.crn_cref() != null){
            newUserProfessional.setCrn_cref(userProfessionalDto.crn_cref());
        }
        if(userProfessionalDto.rating() != null){
            newUserProfessional.setRating(userProfessionalDto.rating());
        }
        if(userProfessionalDto.fk_address() != null){
            List<AddressModel> listAddress = new ArrayList<>();
            for (Integer professionalId :
                    userProfessionalDto.fk_address()) {
                listAddress.add(addressRepository.findById(professionalId).get());
            }
            newUserProfessional.setFk_address(listAddress);
        }

        if(encryptedPassword != null){
            newUserProfessional.setPassword(encryptedPassword);
        }

        userProfessionalRepository.save(newUserProfessional);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/userProfessional/{id}")
    public ResponseEntity<Object> getOneUserProfessional(@RequestParam("id") int id){
        Optional<UserProfessionalModel> userProfessionalReturn = userProfessionalRepository.findById(id);

        if(userProfessionalReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userProfessionalReturn.get());
    }
    @PutMapping("/userProfessional")
    public ResponseEntity<Object> updateUserProfessional(@RequestParam("id") int id,
                                              @RequestBody UserProfessionalDto userProfessionalDto)
    {
        Optional<UserProfessionalModel> updatedUserProfessional = userProfessionalRepository.findById(id);


        if(updatedUserProfessional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(userProfessionalDto.name() != null){
            updatedUserProfessional.get().setName(userProfessionalDto.name());
        }
        if(userProfessionalDto.gender() != null){
            updatedUserProfessional.get().setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.job() != null){
            updatedUserProfessional.get().setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.crn_cref() != null){
            updatedUserProfessional.get().setCrn_cref(userProfessionalDto.crn_cref());
        }
        if(userProfessionalDto.rating() != null){
            updatedUserProfessional.get().setRating(userProfessionalDto.rating());
        }
        if(userProfessionalDto.fk_address().size() > 0){
            List<AddressModel> listAddress = new ArrayList<>();
            for (Integer professionalId :
                    userProfessionalDto.fk_address()) {
                listAddress.add(addressRepository.findById(professionalId).get());
            }
            updatedUserProfessional.get().setFk_address(listAddress);
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedUserProfessional);
    }

    @DeleteMapping("/userProfessional")
    public ResponseEntity<Object> deleteUserProfessional(@RequestParam("id") int id){
        Optional<UserProfessionalModel> deleteUserProfessional = userProfessionalRepository.findById(id);

        if(deleteUserProfessional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        userProfessionalRepository.delete(deleteUserProfessional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
