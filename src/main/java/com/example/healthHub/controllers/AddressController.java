package com.example.healthHub.controllers;

import com.example.healthHub.dtos.AddressDto;
import com.example.healthHub.models.AddressModel;
import com.example.healthHub.models.UserProfessionalModel;
import com.example.healthHub.repositories.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    InfoNutritionalRepository infoNutritionalRepository;
    @Autowired
    UserClientRepository userClientRepository;
    @Autowired
    UserProfessionalRepository userProfessionalRepository;
    @PostMapping("/address")
    public ResponseEntity<Object> saveAddress(@RequestBody AddressDto addressDto){
        AddressModel newAddress = new AddressModel();

        if(addressDto.city() != null){
            newAddress.setCity(addressDto.city());
        }
        if(addressDto.name() != null){
            newAddress.setName(addressDto.name());
        }
        if(addressDto.neighborhood() != null){
            newAddress.setNeighborhood(addressDto.neighborhood());
        }
        if(addressDto.number() != null){
            newAddress.setNumber(addressDto.number());
        }
        if(addressDto.state() != null){
            newAddress.setState(addressDto.state());
        }
        if(addressDto.street() != null){
            newAddress.setStreet(addressDto.street());
        }
        if(addressDto.fk_professional().size() > 0){
            List<UserProfessionalModel> listProfessional = new ArrayList<>();
            for (Integer addressId :
                    addressDto.fk_professional()) {
                listProfessional.add(userProfessionalRepository.findById(addressId).get());
            }
            newAddress.setFk_professional(listProfessional);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.save(newAddress));
    }

    @GetMapping("/address")
    public ResponseEntity<Object> getAllAddress(){
        List<AddressModel> listAddresss = addressRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listAddresss);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Object> getOneAddress(@RequestParam("id") int id){
        Optional<AddressModel> addressReturn = addressRepository.findById(id);

        if(addressReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(addressReturn.get());
    }
    @PutMapping("/address")
    public ResponseEntity<Object> updateAddress(@RequestParam("id") int id,
                                              @RequestBody AddressDto addressDto)
    {
        Optional<AddressModel> updatedAddress = addressRepository.findById(id);


        if(updatedAddress.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(addressDto.city() != null){
            updatedAddress.get().setCity(addressDto.city());
        }
        if(addressDto.name() != null){
            updatedAddress.get().setName(addressDto.name());
        }
        if(addressDto.neighborhood() != null){
            updatedAddress.get().setNeighborhood(addressDto.neighborhood());
        }
        if(addressDto.number() != null){
            updatedAddress.get().setNumber(addressDto.number());
        }
        if(addressDto.state() != null){
            updatedAddress.get().setState(addressDto.state());
        }
        if(addressDto.street() != null){
            updatedAddress.get().setStreet(addressDto.street());
        }
        if(addressDto.fk_professional().size() > 0){
            List<UserProfessionalModel> listProfessional = new ArrayList<>();
            for (Integer addressId :
                    addressDto.fk_professional()) {
                listProfessional.add(userProfessionalRepository.findById(addressId).get());
            }
            updatedAddress.get().setFk_professional(listProfessional);
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedAddress);
    }

    @DeleteMapping("/address")
    public ResponseEntity<Object> deleteAddress(@RequestParam("id") int id){
        Optional<AddressModel> deleteAddress = addressRepository.findById(id);

        if(deleteAddress.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        addressRepository.delete(deleteAddress.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
