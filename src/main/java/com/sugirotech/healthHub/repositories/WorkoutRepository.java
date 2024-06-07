package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.Workout;
import com.sugirotech.healthHub.entities.WorkoutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
    List<Workout> findAllByWorkoutPlan(WorkoutPlan workoutPlan);
}
