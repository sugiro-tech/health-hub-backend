package com.sugirotech.healthHub.services;


import com.sugirotech.healthHub.dtos.workoutplan.InWorkoutPlanDTO;
import com.sugirotech.healthHub.dtos.workoutplan.WorkoutPlanDTO;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.entities.users.UserProfessional;
import com.sugirotech.healthHub.exceptions.InvalidLoginException;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.UserProfessionalRepository;
import com.sugirotech.healthHub.repositories.UserRepository;
import com.sugirotech.healthHub.repositories.WorkoutPlanRepository;
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

    public WorkoutPlanDTO create(InWorkoutPlanDTO data){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();

        System.out.println(userDetails.getUsername());

        WorkoutPlan workoutPlan = new WorkoutPlan(data);

        // Professional

        Optional<UserProfessional> userProfessional = userProfessionalRepository.findByEmail(email);

        if(userProfessional.isPresent()){
            workoutPlan.setUserProfessional(userProfessional.get());

            // Client

            userRepository.findByEmail(data.ClientEmail()).ifPresent(workoutPlan::setUserClient);

            workoutPlanRepository.save(workoutPlan);

            return new WorkoutPlanDTO(workoutPlan);
        }

        throw new InvalidLoginException("non-existing login!");
    }

    public WorkoutPlan findById(Long id){
        return workoutPlanRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout Plan not found!"));
    }
}
