package com.foodapp.Food_Delivery_App.repository;

import com.foodapp.Food_Delivery_App.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer,Integer> {

}
