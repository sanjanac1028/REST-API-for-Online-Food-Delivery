package com.foodapp.Food_Delivery_App.repository;

import com.foodapp.Food_Delivery_App.model.Restaurant;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant, Integer> {
}
