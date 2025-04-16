package com.dev.ecom.service;

import com.dev.ecom.exceptions.APIException;
import com.dev.ecom.exceptions.ResourceNotFoundException;
import com.dev.ecom.model.Category;
import com.dev.ecom.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    //private List<Category> categories = new ArrayList<>();


    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        List<Category> categoriesList = categoryRepository.findAll();

        if(categoriesList.isEmpty()){
            throw new APIException("No category created till now!");
        }

        return categoriesList;
    }

    @Override
    public void createCategory(Category category) {
        Category savedCategoryName = categoryRepository.findByCategoryName(category.getCategoryName());

        if(savedCategoryName != null){
            throw new APIException("Category with name " + category.getCategoryName() + " already exists!");
        }

        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);

        return savedCategory;
    }
}
