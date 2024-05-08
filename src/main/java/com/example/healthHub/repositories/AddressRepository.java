package com.example.healthHub.repositories;

import com.example.healthHub.models.AddressModel;
import com.example.healthHub.models.ChartModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressModel, Integer> {
}
