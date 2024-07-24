package com.foodapp.Food_Delivery_App.authrepository;

import com.foodapp.Food_Delivery_App.authmodels.LogInModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface  LoginModelDAO extends JpaRepository <LogInModel, Integer> {
}
