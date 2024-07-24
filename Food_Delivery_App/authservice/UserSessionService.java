package com.foodapp.Food_Delivery_App.authservice;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.SignUpModel;
import com.foodapp.Food_Delivery_App.authmodels.UserSession;

public interface UserSessionService {
    public UserSession getUserSession(String key) throws AuthorizationException;
    public Integer getUserSessionId(String key) throws AuthorizationException ;
    public SignUpModel getSignUpDetails(String key) throws AuthorizationException;
}
