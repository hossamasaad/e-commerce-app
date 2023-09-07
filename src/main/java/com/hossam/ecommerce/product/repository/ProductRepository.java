package com.hossam.ecommerce.product.repository;

import com.hossam.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
}
