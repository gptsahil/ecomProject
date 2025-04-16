package com.dev.ecom.service;

import com.dev.ecom.model.Category;
import com.dev.ecom.payLoad.CategoryDTO;
import com.dev.ecom.payLoad.CategoryResponse;

import java.util.List;


public interface CategoryService {

    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryID);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
