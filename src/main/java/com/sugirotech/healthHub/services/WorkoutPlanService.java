package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.workoutplan.InWorkoutPlanDTO;
import com.sugirotech.healthHub.dtos.workoutplan.WorkoutPlanDTO;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.WorkoutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutPlanService {

    @Autowired
    private WorkoutPlanRepository workoutPlanRepository;

    // TODO CONTINUAR APOS SECURITY

//    public WorkoutPlanDTO create(InWorkoutPlanDTO data){
//        WorkoutPlan workoutPlan = new WorkoutPlan(data);
//
//        workoutPlan.setUserClient();
//
//    }


    public WorkoutPlan findById(Long id){
        return workoutPlanRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout Plan not found!"));
    }
}
