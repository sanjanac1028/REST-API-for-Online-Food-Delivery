package com.foodapp.Food_Delivery_App.repository;

import com.foodapp.Food_Delivery_App.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO extends JpaRepository<Item,Integer > {
}
