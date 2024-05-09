package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.InExerciseDTO;
import com.sugirotech.healthHub.entities.Exercise;
import com.sugirotech.healthHub.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public InExerciseDTO create(InExerciseDTO data){
        Exercise exercise = new Exercise(data);

        this.exerciseRepository.save(exercise);

        return new InExerciseDTO(exercise);
    }
}
