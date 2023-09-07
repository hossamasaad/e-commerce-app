package com.hossam.ecommerce.cart.repository;

import com.hossam.ecommerce.cart.model.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartItemsRepository extends JpaRepository<CartItems, Integer> {
}
