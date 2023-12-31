package com.hossam.ecommerce.cart.repository;

import com.hossam.ecommerce.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM Cart c WHERE c.customer.id = :customerId")
    List<Cart> getAllCustomerCarts(int customerId);

}
