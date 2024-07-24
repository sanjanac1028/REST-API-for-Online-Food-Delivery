package com.foodapp.Food_Delivery_App.controller;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authservice.UserSessionService;
import com.foodapp.Food_Delivery_App.exceptions.RestaurantException;
import com.foodapp.Food_Delivery_App.model.Restaurant;
import com.foodapp.Food_Delivery_App.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/restaurant")
public class RestaurantServiceController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    UserSessionService userSessionService;

    @PostMapping("/add")
    public ResponseEntity<Restaurant> saveRestaurant(@Valid @RequestBody Restaurant restaurant) throws RestaurantException {
        Restaurant addedRestaurant = restaurantService.addRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(addedRestaurant, HttpStatus.CREATED);
    }
    @PutMapping ("/update")
    public ResponseEntity<Restaurant> updateRestaurant(@Valid @RequestBody Restaurant restaurant) throws RestaurantException {
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(updatedRestaurant, HttpStatus.ACCEPTED);
    }
    @DeleteMapping  ("/remove/{restaurantId}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable ("restaurantId") Integer restaurantId) throws RestaurantException {
        Restaurant deletedRestaurant = restaurantService.removeRestaurant(restaurantId);
        return new ResponseEntity<Restaurant>(deletedRestaurant, HttpStatus.OK);
    }
    @GetMapping  ("/view/{restaurantId}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable ("restaurantId") Integer restaurantId, @RequestParam String key) throws RestaurantException, AuthorizationException {

        Integer sessionId = userSessionService.getUserSessionId(key);

        if(sessionId != null)
        {
            Restaurant restaurant = restaurantService.viewRestaurant(restaurantId);
            return new ResponseEntity<Restaurant>(restaurant, HttpStatus.ACCEPTED);
        }
        else{
            throw new RestaurantException();
        }

    }

}
