package com.foodapp.Food_Delivery_App.authexceptions;

public class AuthorizationException extends Exception{
    public  AuthorizationException(){}
    public AuthorizationException(String message)
    {
        super(message);
    }
}