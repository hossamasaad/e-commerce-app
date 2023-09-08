package com.hossam.ecommerce.cart.service;

import com.hossam.ecommerce.cart.model.CartItem;
import com.hossam.ecommerce.cart.repository.CartItemsRepository;
import com.hossam.ecommerce.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemsService extends GenericService<CartItem> {

    @Autowired
    public CartItemsService(CartItemsRepository cartItemsRepository) {
        super(cartItemsRepository);
    }
}
