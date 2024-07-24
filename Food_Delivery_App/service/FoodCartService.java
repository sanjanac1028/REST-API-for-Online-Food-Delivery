package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CartException;
import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.FoodCart;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.cache.CacheException;

public interface FoodCartService {
    public FoodCart saveCart(FoodCart foodCart) throws CartException;
    public FoodCart addItem(Integer cartId, Integer itemId) throws CartException, ItemException;
    public FoodCart clearCart(Integer cartId) throws CartException;
    public FoodCart viewCart(Integer cartId) throws CartException;

}
