package com.foodapp.Food_Delivery_App.controller;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authservice.UserSessionService;
import com.foodapp.Food_Delivery_App.exceptions.CustomerException;
import com.foodapp.Food_Delivery_App.exceptions.OrderException;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.model.OrderDetails;
import com.foodapp.Food_Delivery_App.service.OrderDetailService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderDetailsServiceController {

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    UserSessionService userSessionService;

    @PostMapping("/save")
    public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails orderDetails, @RequestParam String key) throws AuthorizationException, OrderException {
       Integer sessionId=  userSessionService.getUserSessionId(key);
       if(sessionId!=null)
       {
           return new ResponseEntity<OrderDetails>(orderDetailService.addOrder(orderDetails), HttpStatus.CREATED);
       }
       else {
           throw new OrderException();
       }
    }
    @PutMapping("/update")
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails orderDetails, @RequestParam String key) throws AuthorizationException, OrderException {
        Integer sessionId=  userSessionService.getUserSessionId(key);
        if(sessionId!=null)
        {
            return new ResponseEntity<OrderDetails>(orderDetailService.updateOrder(orderDetails), HttpStatus.ACCEPTED);
        }
        else {
            throw new OrderException();
        }
    }
    @DeleteMapping ("/remove/{orderId}")
    public ResponseEntity<OrderDetails> deleteOrder(@PathVariable ("orderId")  Integer orderId, @RequestParam String key) throws AuthorizationException, OrderException {
        Integer sessionId=  userSessionService.getUserSessionId(key);
        if(sessionId!=null)
        {
            return new ResponseEntity<OrderDetails>(orderDetailService.removeOrder(orderId), HttpStatus.ACCEPTED);
        }
        else {
            throw new OrderException();
        }
    }

    @GetMapping ("/view/{orderId}")
    public ResponseEntity<OrderDetails> viewOrder(@PathVariable ("orderId")  Integer orderId, @RequestParam String key) throws AuthorizationException, OrderException {
        Integer sessionId=  userSessionService.getUserSessionId(key);
        if(sessionId!=null)
        {
            return new ResponseEntity<OrderDetails>(orderDetailService.viewOrder(orderId), HttpStatus.FOUND);
        }
        else {
            throw new OrderException();
        }
    }

    @GetMapping ("/view by customer/{customerId}")
    public ResponseEntity<List<Item>> viewAllOrders(@PathVariable ("customerId")  Integer customerId, @RequestParam String key) throws AuthorizationException, OrderException, CustomerException {
        Integer sessionId=  userSessionService.getUserSessionId(key);
        if(sessionId!=null)
        {
            return new ResponseEntity<List<Item>>(orderDetailService.viewAllOrdersByCustomer(customerId), HttpStatus.FOUND);
        }
        else {
            throw new OrderException();
        }
    }

}
