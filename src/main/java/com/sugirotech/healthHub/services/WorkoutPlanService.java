package com.sugirotech.healthHub.services;


import com.sugirotech.healthHub.dtos.workoutplan.InWorkoutPlanDTO;
import com.sugirotech.healthHub.dtos.workoutplan.WorkoutPlanDTO;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.entities.users.User;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.exceptions.InvalidLoginException;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import com.sugirotech.healthHub.repositories.WorkoutPlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    @Autowired
    private UserProfessionalRepository userProfessionalRepository;

    @Autowired
    private UserRepository userRepository;

    // TODO CONTINUAR APOS SECURITY

    @Transactional
    public WorkoutPlanDTO create(InWorkoutPlanDTO data){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(userDetails.getUsername());

        if(userProfessional.isPresent()){

            Optional<User> user = userRepository.findByEmail(data.ClientEmail());

            if(user.isPresent()){
                WorkoutPlan workoutPlan = new WorkoutPlan(data);

                workoutPlan.setUserProfessional(userProfessional.get());
                workoutPlan.setUserClient(user.get());

                workoutPlanRepository.save(workoutPlan);

                return new WorkoutPlanDTO(workoutPlan);
            }

            throw new NotFoundException("User not found!");
        }

        throw new InvalidLoginException("non-existent login!");
    }

    public WorkoutPlan findById(Long id){
        return workoutPlanRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout Plan not found!"));
    }

    // Criar Get All para os workout plan's do usuário logado

}
