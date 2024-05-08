package com.example.healthHub.repositories;

import com.example.healthHub.models.TrainingPlanModel;
import com.example.healthHub.models.UserClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlanRepository extends JpaRepository<TrainingPlanModel, Integer> {
}
