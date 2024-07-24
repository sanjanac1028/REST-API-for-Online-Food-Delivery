package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.model.Customer;

public interface CustomerService {

    public Customer addCustomer(Customer customer) throws CustomerException;
    public Customer updateCustomer(Customer customer) throws CustomerException;
    public Customer removeCustomer(Integer customerId) throws CustomerException;
    public Customer viewCustomer(Integer CustomerId) throws CustomerException;

}
