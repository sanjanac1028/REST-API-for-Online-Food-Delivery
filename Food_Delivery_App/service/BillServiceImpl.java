package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.BillException;
import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.Bill;
import com.foodapp.Food_Delivery_App.model.Customer;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.repository.BillDAO;
import com.foodapp.Food_Delivery_App.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillDAO billDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Override
    public Bill addBill(Bill bill) throws BillException {
        Optional<Bill> optional = billDAO.findById(bill.getBillId());
        if (optional.isPresent()) {
            throw new BillException("Bill Already Exists");
        } else {
            return billDAO.save(bill);
        }
    }

    @Override
    public Bill updateBill(Bill bill) throws BillException {
        Optional<Bill> optional = billDAO.findById(bill.getBillId());
        if (optional.isPresent()) {
            return billDAO.save(bill);
        } else {
            throw new BillException("Bill Doesn't exists..");
        }
    }

    @Override
    public Bill removeBill(Integer billId) throws BillException {
        Optional<Bill> optionalBill = billDAO.findById(billId);
        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            billDAO.delete(bill);
            return bill;
        } else {
            throw new BillException("Bill not found with Id: " + billId);
        }
    }

    @Override
    public Bill viewBill(Integer billId) throws BillException {
        Optional<Bill> optional = billDAO.findById(billId);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new BillException(" Bill not found with Id: " + billId);
        }
    }

    @Override
    public String generateTotalBillById(Integer customerId) throws ItemException, CustomerException {

        Optional<Customer> optional = customerDAO.findById(customerId);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            List<Item> itemList = customer.getFoodCart().getItemList();
            if (itemList.size() > 0) {
                Double total = 0.0;
                for (Item i : itemList) {

                    total = total + (i.getCost() * i.getQuantity());

                }
                return "The total bill for " + customer.getFullName() + " is " + total;
            } else {
                throw new ItemException("No order items found for " + customer.getFullName());
            }
        } else {
            throw new CustomerException("No Customer found with ID: " + customerId);
        }

    }
}
