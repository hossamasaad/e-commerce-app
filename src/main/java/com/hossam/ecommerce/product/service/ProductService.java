package com.hossam.ecommerce.product.service;


import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.product.model.Product;
import com.hossam.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<Product> {
    @Autowired
    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }
}
