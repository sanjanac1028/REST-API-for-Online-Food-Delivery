package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CategoryException;
import com.foodapp.Food_Delivery_App.model.Category;

import java.util.List;

public interface CategoryService {

    public Category addCategory(Category category) throws CategoryException;
    public Category updateCategory(Category category) throws CategoryException;
    public Category viewCategory(Integer categoryId) throws CategoryException;
    public Category removeCategory(Integer category) throws CategoryException;
    public List<Category> viewAllCategory() throws CategoryException;
}
