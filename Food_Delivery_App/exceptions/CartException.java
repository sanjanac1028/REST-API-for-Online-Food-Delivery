package com.foodapp.Food_Delivery_App.exceptions;

public class CartException extends Exception{
    public CartException(){}
    public CartException(String message)
    {
        super(message);
    }
}
