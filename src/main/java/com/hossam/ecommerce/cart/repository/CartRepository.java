package com.hossam.ecommerce.cart.repository;

import com.hossam.ecommerce.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Integer> {
}
