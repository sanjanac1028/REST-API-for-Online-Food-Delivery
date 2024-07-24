package com.foodapp.Food_Delivery_App.authservice;

import java.util.Random;

public class RandomString
{
    public static String getRandomString(){
        Random random = new Random();
        int number = random.nextInt(999999);
        return String.format("%06d",number);
    }
}
