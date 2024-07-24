package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.RestaurantException;
import com.foodapp.Food_Delivery_App.model.Restaurant;
import com.foodapp.Food_Delivery_App.repository.RestaurantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantDAO restaurantDAO;
    @Override
    public Restaurant addRestaurant(Restaurant restaurant) throws RestaurantException {
        Optional<Restaurant> optional = restaurantDAO.findById(restaurant.getRestaurantId());
        if (optional.isPresent())
        {
            throw new RestaurantException("Restaurant already exists..");
        }
        else {
            return restaurantDAO.save(restaurant);
        }
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantException {
        Optional<Restaurant> optional = restaurantDAO.findById(restaurant.getRestaurantId());
        if (optional.isPresent())
        {
            return restaurantDAO.save(restaurant);
        }
        else {
            throw new RestaurantException("Restaurant Doesn't exists..");
        }
    }

    @Override
    public Restaurant removeRestaurant(Integer restaurantId) throws RestaurantException {
       Optional<Restaurant> optional = restaurantDAO.findById(restaurantId);
       if(optional.isPresent())
       {
           Restaurant deleteRestaurant = optional.get();
           restaurantDAO.delete(deleteRestaurant);
           return deleteRestaurant;
       }
       else {
           throw new RestaurantException("No such restaurant found with id: "+restaurantId);
       }
    }

    @Override
    public Restaurant viewRestaurant(Integer restaurantId) throws RestaurantException {
        Optional<Restaurant> optional = restaurantDAO.findById(restaurantId);
        if(optional.isPresent())
        {
            return optional.get();
        }
        else {
            throw new RestaurantException("No such restaurant found with id: "+restaurantId);
        }
    }
}
