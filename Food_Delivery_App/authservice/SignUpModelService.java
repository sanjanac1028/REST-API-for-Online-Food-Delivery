package com.foodapp.Food_Delivery_App.authservice;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.SignUpModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpModelService  {
   public SignUpModel newSignUp(SignUpModel signUpModel) throws AuthorizationException;
    public SignUpModel updateSignUp( SignUpModel signUpModel, String key) throws AuthorizationException;
}
