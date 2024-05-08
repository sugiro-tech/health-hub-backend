package com.example.healthHub.repositories;

import com.example.healthHub.models.ExerciseModel;
import com.example.healthHub.models.InfoNutritionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseModel, Integer> {
}
