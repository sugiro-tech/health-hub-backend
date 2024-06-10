package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.workout.InWorkoutDTO;
import com.sugirotech.healthHub.dtos.workout.WorkoutDTO;
import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    // busca de workout por id
    // Método utilizado apenas pelo 'ExerciseService'

    public Workout findById(Long id){
        return workoutRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout not found!"));
    }

    // Buscar 'workout's' pelo 'workout plan'

    public List<WorkoutDTO> getByWorkoutPlan(Long id){

        WorkoutPlan workoutPlan = workoutPlanService.findById(id);

        return workoutRepository.findAllByWorkoutPlan(workoutPlan).stream().map(WorkoutDTO::new).toList();
    }
}
