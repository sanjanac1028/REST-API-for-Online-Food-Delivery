package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.Item;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {
    public Item addItem(Item item) throws ItemException;

    public Item updateItem(Item item) throws ItemException;
    public Item viewItem(Integer itemId) throws ItemException;
    public Item removeItem(Integer itemId) throws ItemException;
    public List<Item> viewALlItems() throws ItemException;

}
