package com.sugirotech.healthHub.repositories;

import com.sugirotech.healthHub.entities.InfoNutri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoNutriRepository extends JpaRepository<InfoNutri, Long> {
}
