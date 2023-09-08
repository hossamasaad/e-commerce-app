package com.hossam.ecommerce.category.controller;


import com.hossam.ecommerce.category.model.Category;
import com.hossam.ecommerce.category.service.CategoryService;
import com.hossam.ecommerce.common.GenericController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController extends GenericController<Category> {

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
    }

}
