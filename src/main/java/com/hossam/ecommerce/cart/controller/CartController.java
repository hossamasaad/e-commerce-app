package com.hossam.ecommerce.cart.controller;


import com.hossam.ecommerce.cart.model.Cart;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable int cartId){
        return Cart.builder().build();
    }

    @PostMapping
    public Cart updateCart(@RequestBody Cart cart){
        return cart;
    }

    @PutMapping("/{cartId}")
    public Cart updateCart(@PathVariable int cartId, @RequestBody Cart cart){
        return cart;
    }

    @DeleteMapping("/{cartId}")
    public Cart deleteCart(@PathVariable int cartId){
        return Cart.builder().build();
    }

}
