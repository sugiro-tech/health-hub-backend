package com.example.healthHub.repositories;

import com.example.healthHub.models.DietPlanModel;
import com.example.healthHub.models.EducationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietPlanRepository extends JpaRepository<DietPlanModel, Integer> {
}
