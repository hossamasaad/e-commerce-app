package com.hossam.ecommerce.category.controller;


import com.hossam.ecommerce.category.model.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId){
        return Category.builder().build();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category){
        return category;
    }


    @PutMapping("/{categoryId}")
    public Category updateCategory(@PathVariable int categoryId, @RequestBody Category category){
        return category;
    }

    @DeleteMapping("/{categoryId}")
    public Category deleteCategory(@PathVariable int categoryId){
        return Category.builder().build();
    }

    @GetMapping("/{categoryId}/name")
    public Category getCategoryNameById(@PathVariable int categoryId){
        return Category.builder().build();
    }

    @GetMapping("/{categoryId}/description")
    public Category getCategoryDescriptionById(@PathVariable int categoryId){
        return Category.builder().build();
    }

}
