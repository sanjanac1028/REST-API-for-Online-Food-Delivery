package com.foodapp.Food_Delivery_App.exceptions;

public class OrderException extends Exception{
    public OrderException(){}
    public OrderException(String message)
    {
        super(message);
    }
}
