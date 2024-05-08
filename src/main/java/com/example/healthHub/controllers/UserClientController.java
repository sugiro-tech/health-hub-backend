package com.example.healthHub.controllers;

import com.example.healthHub.dtos.UserClientDto;
import com.example.healthHub.infra.security.TokenService;
import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.repositories.AddressRepository;
import com.example.healthHub.repositories.UserClientRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
public class UserClientController {
    @Autowired
    UserClientRepository userClientRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;

    @PostMapping("/userClient")
    public ResponseEntity<Object> saveUserClient(@RequestBody UserClientDto userClientDto){
        UserClientModel newUserClient = new UserClientModel();

        if(userClientDto.age() != null){
            newUserClient.setAge(userClientDto.age());
        }
        if(userClientDto.name() != null){
            newUserClient.setName(userClientDto.name());
        }
        if(userClientDto.gender() != null){
            newUserClient.setGender(userClientDto.gender());
        }
        if(userClientDto.fk_address() != null){
            newUserClient.setFk_address(addressRepository.findById(userClientDto.fk_address()).get());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userClientRepository.save(newUserClient));
    }

    @GetMapping("/userClient")
    public ResponseEntity<Object> getAllUserClient(){
        List<UserClientModel> listUserClients = userClientRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUserClients);
    }

    @GetMapping("/userClient/{id}")
    public ResponseEntity<Object> getOneUserClient(@RequestParam("id") int id){
        Optional<UserClientModel> userClientReturn = userClientRepository.findById(id);

        if(userClientReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userClientReturn.get());
    }
    @PostMapping("/userClient/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserClientDto userClientDto){
        var usernamePassword = new UsernamePasswordAuthenticationToken(userClientDto.email(), userClientDto.password());
      var auth = this.authenticationManager.authenticate(usernamePassword);

      var token = tokenService.generateToken((UserClientModel) auth.getPrincipal());
      return ResponseEntity.status(HttpStatus.OK).body(token);
    }
    @PostMapping("userClient/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UserClientDto userClientDto){
        if(userClientRepository.findByEmailExists(userClientDto.email()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(userClientDto.password());
        UserClientModel user = new UserClientModel();
        if(userClientDto.fk_address() != null){
            user.setFk_address(addressRepository.findById(userClientDto.fk_address()).get());
        }
        if(userClientDto.age() != null){
            user.setAge(userClientDto.age());
        }
        if(userClientDto.name() != null){
            user.setName(userClientDto.name());
        }
        if(userClientDto.email() != null){
            user.setEmail(userClientDto.email());
        }
        if(userClientDto.gender() != null){
            user.setGender(userClientDto.gender());
        }
        if(encryptedPassword != null){
            user.setPassword(encryptedPassword);
        }

        userClientRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/userClient")
    public ResponseEntity<Object> updateUserClient(@RequestParam("id") int id,
                                              @RequestBody UserClientDto userClientDto)
    {
        Optional<UserClientModel> updatedUserClient = userClientRepository.findById(id);


        if(updatedUserClient.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(userClientDto.age() != null){
            updatedUserClient.get().setAge(userClientDto.age());
        }
        if(userClientDto.name() != null){
            updatedUserClient.get().setName(userClientDto.name());
        }
        if(userClientDto.gender() != null){
            updatedUserClient.get().setGender(userClientDto.gender());
        }
        if(userClientDto.fk_address() != null){
            updatedUserClient.get().setFk_address(addressRepository.findById(userClientDto.fk_address()).get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedUserClient);
    }

    @DeleteMapping("/userClient")
    public ResponseEntity<Object> deleteUserClient(@RequestParam("id") int id){
        Optional<UserClientModel> deleteUserClient = userClientRepository.findById(id);

        if(deleteUserClient.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        userClientRepository.delete(deleteUserClient.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
