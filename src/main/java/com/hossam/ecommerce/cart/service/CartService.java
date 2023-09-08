package com.hossam.ecommerce.cart.service;


import com.hossam.ecommerce.cart.model.Cart;
import com.hossam.ecommerce.cart.repository.CartRepository;
import com.hossam.ecommerce.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService extends GenericService<Cart> {

    @Autowired
    public CartService(CartRepository cartRepository) {
        super(cartRepository);
    }


    public List<Cart> getAllCustomerCart(int customerId){
        return ((CartRepository) super.repo).getAllCustomerCarts(customerId);
    }
}
