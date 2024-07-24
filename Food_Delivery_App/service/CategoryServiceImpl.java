package com.foodapp.Food_Delivery_App.service;

import com.foodapp.Food_Delivery_App.exceptions.CategoryException;
import com.foodapp.Food_Delivery_App.model.Category;
import com.foodapp.Food_Delivery_App.repository.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryDAO categoryDAO;
    @Override
    public Category addCategory(Category category) throws CategoryException {
       Optional<Category> optional = categoryDAO.findById(category.getCategoryId());
       if (optional.isPresent())
       {
            throw new CategoryException("Category already exists");
       }
       else {
           return categoryDAO.save(category);
       }
    }

    @Override
    public Category updateCategory(Category category) throws CategoryException {
        Optional<Category> optional = categoryDAO.findById(category.getCategoryId());
        if (optional.isPresent())
        {
            return categoryDAO.save(category);

        }
        else {
            throw new CategoryException("No Such Category Found");
        }
    }

    @Override
    public Category viewCategory(Integer categoryId) throws CategoryException {
        Optional<Category> optional = categoryDAO.findById(categoryId);
        if (optional.isPresent())
        {
            return optional.get();

        }
        else {
            throw new CategoryException("No Category found with ID: "+categoryId);
        }
    }

    @Override
    public Category removeCategory(Integer categoryId) throws CategoryException {
        Optional<Category> optional = categoryDAO.findById(categoryId);
        if (optional.isPresent())
        {
            Category category =optional.get();
            categoryDAO.delete(category);
            return category;

        }
        else {
            throw new CategoryException("No Category found with ID: "+categoryId);
        }
    }

    @Override
    public List<Category> viewAllCategory() throws CategoryException {
        List<Category> list = categoryDAO.findAll();
        if(list.isEmpty())
        {
            throw new CategoryException("No Categories Exist");
        }
        else {
            return list;
        }
    }
}
