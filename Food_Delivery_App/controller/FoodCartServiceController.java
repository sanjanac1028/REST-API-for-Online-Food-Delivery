package com.foodapp.Food_Delivery_App.controller;

import com.foodapp.Food_Delivery_App.authexceptions.AuthorizationException;
import com.foodapp.Food_Delivery_App.authservice.UserSessionService;
import com.foodapp.Food_Delivery_App.exceptions.CartException;
import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.FoodCart;
import com.foodapp.Food_Delivery_App.service.FoodCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class FoodCartServiceController {

    @Autowired
    FoodCartService foodCartService;
    @Autowired
    UserSessionService userSessionService;


    @PostMapping("/register")
    public ResponseEntity<FoodCart> saveCartDetails(@RequestParam String key, @RequestBody FoodCart foodCart) throws CartException, AuthorizationException {
        Integer sessionId = userSessionService.getUserSessionId(key);
        if(sessionId!=null && foodCart!=null)
        {
            FoodCart newCart = foodCartService.saveCart(foodCart);
            return new ResponseEntity<FoodCart>(newCart, HttpStatus.CREATED);
        }else {
            throw new CartException();
        }

    }

    @PutMapping ("/add/{cartId}/{itemId}")
    public ResponseEntity<FoodCart> saveCartDetails(@PathVariable ("cartId") Integer cartId, @PathVariable ("itemId") Integer itemId) throws CartException, AuthorizationException, ItemException {
            FoodCart updatedCart = foodCartService.addItem(cartId,itemId);
            return new ResponseEntity<FoodCart>(updatedCart,HttpStatus.ACCEPTED);
    }

    @DeleteMapping  ("/remove/{cartId}")
    public ResponseEntity<FoodCart> removeCart(@PathVariable ("cartId") Integer cartId) throws CartException {
        FoodCart clearedCart = foodCartService.clearCart(cartId);
        return new ResponseEntity<FoodCart>(clearedCart,HttpStatus.OK);
    }

    @GetMapping  ("/view/{cartId}")
    public FoodCart getCartByCartId(@PathVariable ("cartId") Integer cartId,@RequestParam String key) throws CartException, AuthorizationException {

        Integer sessionId= userSessionService.getUserSessionId(key);
        if(sessionId!= null)
        {
            return  foodCartService.viewCart(cartId);
        }
        else{
            throw new CartException();
        }

    }
}
