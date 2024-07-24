package com.foodapp.Food_Delivery_App.authcontroller;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.LogInModel;
import com.foodapp.Food_Delivery_App.authservice.LogInModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    LogInModelService logInModelService;

    @PostMapping("/login")
    public String loginHandler(@RequestBody LogInModel logInModel) throws AuthorizationException {
        return logInModelService.logIn(logInModel);
    }

    @PatchMapping("/logout")
    public String logOutFromAccount(@RequestParam String  key) throws AuthorizationException {
        return logInModelService.logOut(key);
    }
}
