package com.example.healthHub.repositories;

import com.example.healthHub.models.ServicesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicesRepository extends JpaRepository<ServicesModel, Integer> {
}
