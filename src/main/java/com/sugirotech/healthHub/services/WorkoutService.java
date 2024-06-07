package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.workout.InWorkoutDTO;
import com.sugirotech.healthHub.dtos.workout.WorkoutDTO;
import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutPlanService workoutPlanService;

    // Criação de Workout

    public WorkoutDTO create(InWorkoutDTO data){
        Workout workout = new Workout(data);

        workout.setWorkoutPlan(workoutPlanService.findById(data.workoutPlanId()));

        this.workoutRepository.save(workout);

        return new WorkoutDTO(workout);
    }

    // TODO REVER NECESSIDADE DE DTO NO RETORNO

    // busca de workout por id

    public Workout findById(Long id){
        return workoutRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout not found!"));
    }

    public List<WorkoutDTO> getByWorkoutPlan(Long id){

//        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();


        WorkoutPlan workoutPlan = workoutPlanService.findById(id);

        return workoutRepository.findAllByWorkoutPlan(workoutPlan).stream().map(WorkoutDTO::new).toList();
    }
}
