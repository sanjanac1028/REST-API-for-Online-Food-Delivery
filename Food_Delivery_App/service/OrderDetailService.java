package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.exceptions.OrderException;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.model.OrderDetails;

import java.util.List;

public interface OrderDetailService {

    public OrderDetails addOrder(OrderDetails orderDetails) throws OrderException;
    public OrderDetails updateOrder(OrderDetails orderDetails) throws OrderException;
    public OrderDetails removeOrder(Integer orderId) throws OrderException;
    public OrderDetails viewOrder(Integer orderId) throws OrderException;
    public List<Item> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException;

}
