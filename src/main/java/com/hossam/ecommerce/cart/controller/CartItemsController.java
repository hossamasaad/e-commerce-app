package com.hossam.ecommerce.cart.controller;

import com.hossam.ecommerce.cart.model.CartItem;
import com.hossam.ecommerce.cart.service.CartItemsService;
import com.hossam.ecommerce.common.GenericController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart-item")
public class CartItemsController extends GenericController<CartItem> {

    public CartItemsController(CartItemsService cartItemsService) {
        super(cartItemsService);
    }

}
