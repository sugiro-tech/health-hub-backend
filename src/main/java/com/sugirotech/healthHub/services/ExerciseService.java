package com.sugirotech.healthHub.services;

import com.sugirotech.healthHub.dtos.exercise.ExerciseDTO;
import com.sugirotech.healthHub.dtos.exercise.InExerciseDTO;
import com.sugirotech.healthHub.entities.Exercise;
import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import com.sugirotech.healthHub.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private WorkoutService workoutService;

    public ExerciseDTO create(InExerciseDTO data){
        Exercise exercise = new Exercise(data);

        exercise.setWorkout(workoutService.findById(data.workoutID()));

        this.exerciseRepository.save(exercise);

        return new ExerciseDTO(exercise);
    }

    public List<ExerciseDTO> getAll(Long id){

        Workout workout = workoutService.findById(id);

        return this.exerciseRepository.findAllByWorkout(workout).stream().map(ExerciseDTO::new).toList();
    }

    public ExerciseDTO getById(Long id){
        return new ExerciseDTO(exerciseRepository.findById(id).orElseThrow(() -> new NotFoundException("Exercise not found!")));
    }
}
