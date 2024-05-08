package com.example.healthHub.repositories;

import com.example.healthHub.models.EducationModel;
import com.example.healthHub.models.ExerciseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<EducationModel, Integer> {
}
