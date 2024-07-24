package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.model.Customer;
import com.foodapp.Food_Delivery_App.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerDAO customerDAO;
    @Override
    public Customer addCustomer(Customer customer) throws CustomerException {
        Optional<Customer> optional = customerDAO.findById(customer.getCustomerId());
        if(optional.isPresent())
        {
            throw new CustomerException("Customer already exists...");
        }
        else {
            return customerDAO.save(customer);
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerException{
        Optional<Customer> optional = customerDAO.findById(customer.getCustomerId());
        if(optional.isPresent())
        {
            return customerDAO.save(customer);
        }
        else {
            throw new CustomerException("No such Customer exists...");
        }
    }

    @Override
    public Customer removeCustomer(Integer customerId) throws CustomerException {
        Optional<Customer> optional = customerDAO.findById(customerId);
        if (optional.isPresent())
        {
           Customer customer1 = optional.get();
            customerDAO.delete(customer1);
            return customer1;
        }
        else{
            throw new CustomerException("No Customer found with id:" +customerId);
        }
    }

    @Override
    public Customer viewCustomer(Integer customerId) throws CustomerException {
        Optional<Customer> optional = customerDAO.findById(customerId);
        if(optional.isPresent())
        {
            Customer customer1 = optional.get();
            return customer1;
        }
        else{
            throw new CustomerException("No Customer found with id:" +customerId);
        }
    }
}
