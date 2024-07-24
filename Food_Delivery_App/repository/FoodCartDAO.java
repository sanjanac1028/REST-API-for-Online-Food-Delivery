package com.foodapp.Food_Delivery_App.repository;

import com.foodapp.Food_Delivery_App.model.FoodCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodCartDAO extends JpaRepository<FoodCart, Integer> {
}
