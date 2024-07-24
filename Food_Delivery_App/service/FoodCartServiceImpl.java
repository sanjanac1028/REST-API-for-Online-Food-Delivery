package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CartException;
import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.FoodCart;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.repository.FoodCartDAO;
import com.foodapp.Food_Delivery_App.repository.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodCartServiceImpl implements FoodCartService {

    @Autowired
    FoodCartDAO foodCartDAO;
    @Autowired
    ItemDAO itemDAO;

    @Override
    public FoodCart saveCart(FoodCart foodCart) throws CartException {
        Optional<FoodCart> optional = foodCartDAO.findById(foodCart.getCartId());
        if (optional.isPresent()) {
            throw new CartException("Cart already exists..");
        } else {
            return foodCartDAO.save(foodCart);
        }
    }

    @Override
    public FoodCart addItem(Integer cartId, Integer itemId) throws CartException, ItemException {
        Optional<FoodCart> cartOptional = foodCartDAO.findById(cartId);
        if (cartOptional.isPresent()) {
            Optional<Item> itemOptional = itemDAO.findById(itemId);
            if (itemOptional.isPresent()) {
                FoodCart foodCart =cartOptional.get();
                Item item = itemOptional.get();
                List<Item> itemList =new ArrayList<>();
                itemList.addAll(foodCart.getItemList());
                itemList.add(item);
                foodCart.setItemList(itemList);
                return foodCart;

            }
            else {
                throw new ItemException("No Item found with ID: "+ itemId);
            }
        }
        else {
            throw new CartException("No Cart found with ID: "+ cartId);
        }
    }

    @Override
    public FoodCart clearCart(Integer cartId) throws CartException {
        Optional<FoodCart> optional = foodCartDAO.findById(cartId);
        if (optional.isPresent()) {
            FoodCart cart = optional.get();
            foodCartDAO.delete(cart);
            return cart;
        } else {
            throw new CartException("No cart found with Id: " + cartId);
        }
    }

    @Override
    public FoodCart viewCart(Integer cartId) throws CartException {
        Optional<FoodCart> optional = foodCartDAO.findById(cartId);
        if (optional.isPresent()) {
            FoodCart cart = optional.get();
            return cart;
        } else {
            throw new CartException("No cart found with Id: " + cartId);
        }
    }
}
