package com.foodapp.Food_Delivery_App.controller;

import com.foodapp.Food_Delivery_App.exceptions.BillException;
import com.foodapp.Food_Delivery_App.model.Bill;
import com.foodapp.Food_Delivery_App.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillServiceController {
    @Autowired
    BillService billService;

    @PostMapping("/add")
    public ResponseEntity<Bill> generateBill(@RequestBody Bill bill) throws BillException {
       Bill addedBill = billService.addBill(bill);
       return new ResponseEntity<Bill>(addedBill , HttpStatus.CREATED);
    }
    @PostMapping("/update")
    public ResponseEntity<Bill> updateBill(@RequestBody Bill bill) throws BillException {
        Bill updatedBill = billService.updateBill(bill);
        return new ResponseEntity<Bill>(updatedBill , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remove/{billId}")
    public ResponseEntity<Bill> removeBill(@PathVariable("billId") Integer billId) throws BillException {
    Bill deletedBill =billService.removeBill(billId);
    return new ResponseEntity<Bill>(deletedBill ,HttpStatus.OK);
    }

    @GetMapping("/view/{billId}")
    public ResponseEntity<Bill> viewBill(@PathVariable("billId") Integer billId) throws BillException {
        Bill bill =billService.viewBill(billId);
        return new ResponseEntity<Bill>(bill ,HttpStatus.ACCEPTED);
    }


}
