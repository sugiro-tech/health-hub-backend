package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.address.AddressDTO;
import com.sugirotech.healthHub.dtos.address.InAddressDTO;
import com.sugirotech.healthHub.entities.Address;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.exceptions.InvalidLoginException;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.AddressRepository;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfessionalRepository userProfessionalRepository;

    // CREATE

    @Transactional
    public AddressDTO create (InAddressDTO data){

        Address address = new Address(data);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(userDetails.getUsername());

        if(userProfessional.isPresent()){
            UserProfessional existingUserProfessional = userProfessional.get();

            existingUserProfessional.getAddresses().add(address);
            address.getProfessionals().add(existingUserProfessional);

            this.userProfessionalRepository.save(existingUserProfessional);
            this.addressRepository.save(address);

            return new AddressDTO(address);
        }

        Optional<User> user = userRepository.findByEmail(userDetails.getUsername());

        if(user.isPresent()){
            User existingUser = user.get();

            existingUser.getAddresses().add(address);
            address.getClients().add(existingUser);

            this.userRepository.save(existingUser);
            this.addressRepository.save(address);

            return new AddressDTO(address);
        }
        throw new NotFoundException("Client/Professional not found!");
    }

    // GET ALL

    public List<AddressDTO> getAll() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = userDetails.getUsername();

            System.out.println("Authenticated username: " + username);

            Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(username);
            if (userProfessional.isPresent()) {
                return filterAddressesByUserType(username, "professional");
            }

            Optional<User> userClient = userRepository.findByEmail(username);
            if (userClient.isPresent()) {
                return filterAddressesByUserType(username, "client");
            }

            throw new NotFoundException("User not found!");

        } catch (Exception e) {
            throw new InvalidLoginException("non-existent login!");
        }
    }

    // -- Auxiliar

    /*

    Function used to filter addresses by logged user! - used on 'GetAll'

     */

    private List<AddressDTO> filterAddressesByUserType(String username, String userType) {
        return addressRepository.findAll().stream()
                .peek(address -> {
                    if (userType.equals("professional")) {
                        List<String> professionalUsernames = address.getProfessionals().stream()
                                .map(UserProfessional::getUsername)
                                .toList();
                        System.out.println("Address ID: " + address.getId() + ", Professionals: " + professionalUsernames);
                    } else if (userType.equals("client")) {
                        List<String> clientUsernames = address.getClients().stream()
                                .map(User::getUsername)
                                .toList();
                        System.out.println("Address ID: " + address.getId() + ", Clients: " + clientUsernames);
                    }
                })
                .filter(address -> {
                    if (userType.equals("professional")) {
                        return address.getProfessionals().stream().anyMatch(user -> user.getUsername().equals(username));
                    } else if (userType.equals("client")) {
                        return address.getClients().stream().anyMatch(user -> user.getUsername().equals(username));
                    }
                    return false;
                })
                .map(AddressDTO::new)
                .collect(Collectors.toList());
    }

    // SAVE

    public void save(InAddressDTO data){
        addressRepository.save(new Address(data));
    }
}
