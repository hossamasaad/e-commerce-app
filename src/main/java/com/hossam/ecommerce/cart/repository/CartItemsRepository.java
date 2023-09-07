package com.hossam.ecommerce.cart.repository;

import com.hossam.ecommerce.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemsRepository extends JpaRepository<CartItem, Integer> {
}
