package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.Workout.InWorkoutDTO;
import com.sugirotech.healthHub.dtos.Workout.WorkoutDTO;
import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    public WorkoutDTO create(InWorkoutDTO data){
        Workout workout = new Workout(data);

        this.workoutRepository.save(workout);

        return new WorkoutDTO(workout);
    }

    public Workout findById(Long id){
        return workoutRepository.findById(id).orElseThrow(() -> new NotFoundException("Workout not found!"));
    }
}
