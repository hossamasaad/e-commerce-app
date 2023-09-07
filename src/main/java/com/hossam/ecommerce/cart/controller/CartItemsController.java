package com.hossam.ecommerce.cart.controller;

import com.hossam.ecommerce.cart.model.CartItem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart-item")
public class CartItemsController {

    @GetMapping("/{cartItemId}")
    public CartItem getCartItemsById(@PathVariable int cartItemsId){
        return CartItem.builder().build();
    }

    @PostMapping
    public CartItem addCartItems(){
        return CartItem.builder().build();
    }

    @PutMapping("/{cartItemId}")
    public CartItem updateCartItemsById(@PathVariable int cartItemId){
        return CartItem.builder().build();
    }

    @DeleteMapping("/{cartItemId}")
    public CartItem deleteCartItemsById(@PathVariable int cartItemId){
        return CartItem.builder().build();
    }

    @GetMapping("/{cartItemId}/quantity")
    public int getQuantityById(@PathVariable int cartItemId){
        return 0;
    }

    @PutMapping("/{cartItemId}/quantity")
    public int updateQuantityById(@PathVariable int cartItemId){
        return 0;
    }

}
