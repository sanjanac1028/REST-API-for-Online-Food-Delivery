package com.foodapp.Food_Delivery_App.authcontroller;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authmodels.SignUpModel;
import com.foodapp.Food_Delivery_App.authservice.SignUpModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SignUpController {

    @Autowired
    SignUpModelService service;
    @PostMapping("/signUp")
    public ResponseEntity<SignUpModel> createNewSignUpHandler(@RequestBody SignUpModel newSignUp) throws AuthorizationException {

        SignUpModel newSignedUp =service.newSignUp(newSignUp);
        return new ResponseEntity<SignUpModel>(newSignedUp, HttpStatus.CREATED);

    }

    @PutMapping("/updateSignUp")
    public ResponseEntity<SignUpModel> updateSignUpDetailsHandler(@RequestBody SignUpModel signUp, @RequestParam String key) throws AuthorizationException
    {
        SignUpModel newUpdatedSignUp = service.updateSignUp(signUp,key);
        return new ResponseEntity<SignUpModel>(newUpdatedSignUp,HttpStatus.ACCEPTED);


    }
}
