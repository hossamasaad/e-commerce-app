package com.hossam.ecommerce.product.controller;


import com.hossam.ecommerce.common.GenericController;
import com.hossam.ecommerce.product.model.Product;
import com.hossam.ecommerce.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController extends GenericController<Product> {
    public ProductController(ProductService productService) {
        super(productService);
    }
}
