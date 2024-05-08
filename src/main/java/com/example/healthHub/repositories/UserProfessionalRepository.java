package com.example.healthHub.repositories;

import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfessionalRepository extends JpaRepository<UserProfessionalModel, Integer> {
    @Query("SELECT t FROM UserProfessionalModel t WHERE t.email = :login")
    UserDetails findByEmail(String login);
    @Query("SELECT t FROM UserProfessionalModel t WHERE t.email = :login")
    UserProfessionalModel findByEmailExists(String login);

}
