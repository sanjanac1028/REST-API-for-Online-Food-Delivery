package com.foodapp.Food_Delivery_App.authservice;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.SignUpModel;
import com.foodapp.Food_Delivery_App.authmodels.UserSession;
import com.foodapp.Food_Delivery_App.authrepository.SignUpModelDAO;
import com.foodapp.Food_Delivery_App.authrepository.UserSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSessionServiceImpl implements UserSessionService{

    @Autowired
    UserSessionDAO userSessionDAO;

    @Autowired
    SignUpModelDAO signUpModelDAO;

    @Override
    public UserSession getUserSession(String key) throws AuthorizationException {
        Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
        if(!currentUser.isPresent())
        {
            throw new AuthorizationException("Not Authorized..!!");
        }
        return currentUser.get();
    }

    @Override
    public Integer getUserSessionId(String key) throws AuthorizationException  {
       Optional<UserSession> currentUser =  userSessionDAO.findByUUID(key);
       if(!currentUser.isPresent())
       {
           throw new AuthorizationException("Not Authorized..!!");
       }
      return currentUser.get().getId();
    }

    @Override
    public SignUpModel getSignUpDetails(String key) {
        Optional<UserSession> currentUser = userSessionDAO.findByUUID(key);
        if(!currentUser.isPresent()){
            return null;
        }
        Integer signUpUserId = currentUser.get().getUserId();
        System.out.println(signUpUserId);
        return signUpModelDAO.findById(signUpUserId).get();
    }
}
