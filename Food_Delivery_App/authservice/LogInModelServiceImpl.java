package com.foodapp.Food_Delivery_App.authservice;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.LogInModel;
import com.foodapp.Food_Delivery_App.authmodels.SignUpModel;
import com.foodapp.Food_Delivery_App.authmodels.UserSession;
import com.foodapp.Food_Delivery_App.authrepository.LoginModelDAO;
import com.foodapp.Food_Delivery_App.authrepository.SignUpModelDAO;
import com.foodapp.Food_Delivery_App.authrepository.UserSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class LogInModelServiceImpl implements LogInModelService{

    @Autowired
    SignUpModelDAO signUpModelDAO;
    @Autowired
    UserSessionDAO userSessionDAO;
    @Autowired
    LoginModelDAO loginModelDAO;
    @Autowired
    UserSessionService userSessionService;
    @Override
    public String logIn(LogInModel logInModel) throws AuthorizationException {
           Optional<SignUpModel> optional = signUpModelDAO.findById(logInModel.getUserId());
           if(!optional.isPresent())
           {
               throw new AuthorizationException("invalid Login UserId");
           }
           SignUpModel signUpModel = optional.get();
        Integer signUpId = signUpModel.getUserId();
        Optional<UserSession> optional1 = userSessionDAO.findByUserId(signUpId);
        if(optional1.isPresent())
        {
            throw new AuthorizationException("User Already logged in with this user id");
        }
        if((signUpModel.getUserId() == logInModel.getUserId())&& (signUpModel.getPassword().equals(logInModel.getPassword())))
        {
            String key = RandomString.getRandomString();
            UserSession userSession = new UserSession(signUpModel.getUserId(),key, LocalDateTime.now());
            userSessionDAO.save(userSession);
            loginModelDAO.save(logInModel);

            return userSession.toString();

        }
        else{
            throw new AuthorizationException("Invalid Username or Password..");
        }
    }

    @Override
    public String logOut(String key) throws AuthorizationException {
       Optional<UserSession> currentUserOptional = userSessionDAO.findByUUID(key);
       if (!currentUserOptional.isPresent())
       {
           throw new AuthorizationException("Invalid credentials");
       }
       UserSession currentUserSession = userSessionService.getUserSession(key);
       userSessionDAO.delete(currentUserSession);
       Optional<LogInModel> loginData = loginModelDAO.findById(currentUserOptional.get().getUserId());
        System.out.println(loginData);
        loginModelDAO.delete(loginData.get());
        return "Logged Out..";

    }
}
