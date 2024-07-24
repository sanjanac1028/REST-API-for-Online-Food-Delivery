package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.BillException;
import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.Bill;

public interface BillService {

    public Bill addBill(Bill bill) throws BillException;
    public Bill updateBill(Bill bill) throws BillException;
    public Bill removeBill(Integer billId) throws BillException;
    public  Bill viewBill(Integer billId) throws BillException;

    public String generateTotalBillById(Integer customerId)throws ItemException, CustomerException;

}
