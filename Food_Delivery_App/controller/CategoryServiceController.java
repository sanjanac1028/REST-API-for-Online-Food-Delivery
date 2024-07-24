package com.foodapp.Food_Delivery_App.controller;

import com.foodapp.Food_Delivery_App.exceptions.CategoryException;
import com.foodapp.Food_Delivery_App.model.Category;
import com.foodapp.Food_Delivery_App.service.CategoryService;
import com.foodapp.Food_Delivery_App.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryServiceController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) throws CategoryException {
        Category addedCategory = categoryService.addCategory(category);
        return new ResponseEntity<Category>(addedCategory, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) throws CategoryException {
        Category updatedCategory = categoryService.updateCategory(category);
        return new ResponseEntity<Category>(updatedCategory, HttpStatus.ACCEPTED);
    }

    @GetMapping("/view/{categoryId}")
    public ResponseEntity<Category> getCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException {
        Category viewCategory = categoryService.viewCategory(categoryId);
        return new ResponseEntity<>(viewCategory, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{categoryId}")
    public ResponseEntity<Category> removeCategory(@PathVariable("categoryId") Integer categoryId) throws CategoryException {
        Category removeCategory = categoryService.removeCategory(categoryId);
        return new ResponseEntity<Category>(removeCategory,HttpStatus.OK);
    }

    @GetMapping("/view all")
    public ResponseEntity<List<Category>> getAllCategories() throws CategoryException {
        List<Category> allCategories = categoryService.viewAllCategory();
        return new ResponseEntity<List<Category>>(allCategories,HttpStatus.OK);
    }
}
