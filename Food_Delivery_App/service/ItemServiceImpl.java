package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.repository.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemDAO itemDAO;
    @Override
    public Item addItem(Item item) throws ItemException {
       Optional<Item> optionalItem = itemDAO.findById(item.getItemId());
       if(optionalItem.isPresent())
       {
           throw new ItemException("Item already exists..");
       }
       else{
           return itemDAO.save(item);
       }

    }

    @Override
    public Item updateItem(Item item) throws ItemException {
        Optional<Item> optionalItem = itemDAO.findById(item.getItemId());
        if(optionalItem.isPresent())
        {
            return itemDAO.save(item);
        }
        else{
            throw new ItemException("No such Item found");
        }
    }

    public Item viewItem(Integer itemId) throws ItemException {
       Optional<Item> optionalItem = itemDAO.findById(itemId);
       if(optionalItem.isPresent())
       {
           return optionalItem.get();
       }
       else {
           throw new ItemException("No Item found with ID: "+itemId);
       }
    }
    public Item removeItem(Integer itemId) throws ItemException {
        Optional<Item> optionalItem = itemDAO.findById(itemId);
        if (optionalItem.isPresent())
        {
            Item item =optionalItem.get();
            itemDAO.delete(item);
            return item;
        }
        else{
            throw new ItemException("No Item found with ID: " +itemId);
        }
    }

    public List<Item> viewALlItems() throws ItemException {
            List<Item> list = itemDAO.findAll();
            if(list.size() >0)
            {
                return list;
            }
            else {
                throw new ItemException("No Item Exists");
            }
    }


}
