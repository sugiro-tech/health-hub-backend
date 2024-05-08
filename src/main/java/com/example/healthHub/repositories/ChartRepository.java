package com.example.healthHub.repositories;

import com.example.healthHub.models.ChartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartRepository extends JpaRepository<ChartModel, Integer> {
}
