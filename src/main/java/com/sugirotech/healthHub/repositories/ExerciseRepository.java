package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.Exercise;
import com.sugirotech.healthHub.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findAllByWorkout(Workout workout);
}
