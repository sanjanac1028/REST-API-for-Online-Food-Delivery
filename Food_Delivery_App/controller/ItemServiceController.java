package com.foodapp.Food_Delivery_App.controller;

import com.foodapp.Food_Delivery_App.exceptions.ItemException;
import com.foodapp.Food_Delivery_App.model.Item;
import com.foodapp.Food_Delivery_App.repository.ItemDAO;
import com.foodapp.Food_Delivery_App.service.ItemService;
import com.foodapp.Food_Delivery_App.service.ItemServiceImpl;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemServiceController {

    @Autowired
    ItemService itemService;

   @PostMapping("/add")
   public ResponseEntity<Item> addItem(@RequestBody Item item) throws ItemException {

       Item newItem = itemService.addItem(item);
       return new ResponseEntity<Item>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ItemException {
       Item updatedItem = itemService.updateItem(item);
       return new ResponseEntity<Item>(updatedItem,HttpStatus.OK);
    }

    @GetMapping("/view/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable("itemId") Integer itemId) throws ItemException {
       Item item = itemService.viewItem(itemId);
       return new ResponseEntity<Item>(item , HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remove/{itemId}")
    public ResponseEntity<Item> removeItem(@PathVariable ("itemId")Integer itemId) throws ItemException {
        Item removedItem = itemService.removeItem(itemId);
        return new ResponseEntity<Item>(removedItem , HttpStatus.ACCEPTED);
    }

    @GetMapping("/viewAll")
    public ResponseEntity<List<Item>> getAllItems() throws ItemException {
        List<Item> itemList = itemService.viewALlItems();
        return new ResponseEntity<List<Item>>(itemList ,  HttpStatus.OK);
    }

}
