package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.RestaurantException;
import com.foodapp.Food_Delivery_App.model.Restaurant;

public interface RestaurantService {

    public Restaurant addRestaurant(Restaurant restaurant)throws RestaurantException;
    public Restaurant updateRestaurant(Restaurant restaurant)throws RestaurantException;
    public Restaurant removeRestaurant(Integer restaurantId)throws RestaurantException;
    public Restaurant viewRestaurant(Integer restaurantId)throws RestaurantException;

}
