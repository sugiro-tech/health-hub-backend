package com.example.healthHub.repositories;

import com.example.healthHub.models.UserClientModel;
import com.example.healthHub.models.UserProfessionalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<UserClientModel, Integer> {
    @Query("SELECT t FROM UserClientModel t WHERE t.email = :login")
    UserDetails findByEmail(String login);
    @Query("SELECT t FROM UserClientModel t WHERE t.email = :login")
    UserClientModel findByEmailExists(String login);

}
