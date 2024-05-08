package com.example.healthHub.repositories;

import com.example.healthHub.models.DietModel;
import com.example.healthHub.models.DietPlanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<DietModel, Integer> {
}
