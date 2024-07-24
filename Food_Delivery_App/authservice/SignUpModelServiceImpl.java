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
public class SignUpModelServiceImpl implements SignUpModelService{

    @Autowired
    SignUpModelDAO signUpModelDAO;

    @Autowired
    UserSessionService userSessionService;

    @Override
    public SignUpModel newSignUp(SignUpModel signUpModel) throws AuthorizationException{
        Optional<SignUpModel> optional = signUpModelDAO.findByUserName(signUpModel.getUserName());
        if(optional.isPresent())
        {
            throw new AuthorizationException("User Already Exists..!!");
        }
        return signUpModelDAO.save(signUpModel);
    }

    @Override
    public SignUpModel updateSignUp(SignUpModel signUpModel, String key) throws AuthorizationException {
        SignUpModel signUpDetails = userSessionService.getSignUpDetails(key);
        if(signUpDetails == null)
        {
            throw new AuthorizationException("User not Logged In..Try to login first");
        }
        if(signUpDetails.getUserId() == signUpModel.getUserId())
        {
            signUpModelDAO.save(signUpModel);
            return signUpModel;
        }
        else {
            throw new AuthorizationException("userId not found..!!");
        }
    }
}
