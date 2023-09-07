package com.hossam.ecommerce.product.controller;


import com.hossam.ecommerce.product.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId){
        return Product.builder().build();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return product;
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable int productId, @RequestBody Product product){
        return product;
    }

    @DeleteMapping("/{productId}")
    public Product deleteProduct(@PathVariable int productId){
        return Product.builder().build();
    }

}
