package com.example.healthHub.repositories;

import com.example.healthHub.models.InfoNutritionalModel;
import com.example.healthHub.models.TrainingPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoNutritionalRepository extends JpaRepository<InfoNutritionalModel, Integer> {
}
