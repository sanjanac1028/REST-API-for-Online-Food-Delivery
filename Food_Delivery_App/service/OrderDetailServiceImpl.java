package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.exceptions.OrderException;
import com.foodapp.Food_Delivery_App.model.Customer;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.model.OrderDetails;
import com.foodapp.Food_Delivery_App.repository.CustomerDAO;
import com.foodapp.Food_Delivery_App.repository.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDAO orderDAO;

    @Autowired
    CustomerDAO customerDAO;
    @Override
    public OrderDetails addOrder(OrderDetails orderDetails) throws OrderException {
       Optional<OrderDetails> optional = orderDAO.findById(orderDetails.getOrderId());
       if(optional.isPresent())
       {
           throw new OrderException("Order Already Exists");
       }
       else {
          return orderDAO.save(orderDetails);
       }
    }

    @Override
    public OrderDetails updateOrder(OrderDetails orderDetails) throws OrderException {
        Optional<OrderDetails> optional = orderDAO.findById(orderDetails.getOrderId());
        if(optional.isPresent())
        {
            return orderDAO.save(orderDetails);
        }
        else {
            throw new OrderException("Order such order exists..");
        }
    }

    @Override
    public OrderDetails removeOrder(Integer orderId) throws OrderException {
        Optional<OrderDetails> optional = orderDAO.findById(orderId);
        if(optional.isPresent())
        {
            OrderDetails orderDetails = optional.get();
           orderDAO.delete(orderDetails);
            return orderDetails;
        }
        else {
            throw new OrderException("No Order found with ID: "+orderId);
        }
    }

    @Override
    public OrderDetails viewOrder(Integer orderId) throws OrderException {
       Optional<OrderDetails> optional = orderDAO.findById(orderId);
        if(optional.isPresent())
        {
            OrderDetails orderDetails = optional.get();
            return orderDetails;
        }
        else {
            throw new OrderException("No order found with Id: "+orderId);
        }
    }

    @Override
    public List<Item> viewAllOrdersByCustomer(Integer customerId) throws OrderException, CustomerException {
          Optional<Customer> optional =  customerDAO.findById(customerId);
          if(optional.isPresent())
          {
              Customer customer = optional.get();
             List<Item> itemList = customer.getFoodCart().getItemList();
             if(itemList.isEmpty())
             {
                 throw new OrderException("No Orders found..");
             }
             else{
                 return itemList;
             }
          }
          else {
              throw new CustomerException("No Customer found with ID: "+customerId);
          }
    }
}
