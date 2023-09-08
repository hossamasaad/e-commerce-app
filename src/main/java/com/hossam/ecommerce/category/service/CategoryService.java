package com.hossam.ecommerce.category.service;


import com.hossam.ecommerce.category.model.Category;
import com.hossam.ecommerce.category.repository.CategoryRepository;
import com.hossam.ecommerce.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category> {

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        super(categoryRepository);
    }

}
