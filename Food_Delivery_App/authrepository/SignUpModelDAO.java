package com.foodapp.Food_Delivery_App.authrepository;

import com.foodapp.Food_Delivery_App.authmodels.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpModelDAO extends JpaRepository<SignUpModel, Integer> {
    public Optional<SignUpModel> findByUserName(String userId);
}
