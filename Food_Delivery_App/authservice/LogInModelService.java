package com.foodapp.Food_Delivery_App.authservice;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.LogInModel;

public interface LogInModelService {

    public String logIn(LogInModel logInModel) throws AuthorizationException;
    public String logOut(String key) throws AuthorizationException;
}
