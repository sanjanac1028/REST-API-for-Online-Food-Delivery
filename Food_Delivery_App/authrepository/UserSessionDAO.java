package com.foodapp.Food_Delivery_App.authrepository;

import com.foodapp.Food_Delivery_App.authmodels.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserSessionDAO extends JpaRepository<UserSession , Integer> {

    public Optional<UserSession> findByUserId(Integer userId);
   public Optional<UserSession> findByUUID(String UUID);
}
