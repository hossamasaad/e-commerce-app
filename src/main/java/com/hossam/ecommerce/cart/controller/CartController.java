package com.hossam.ecommerce.cart.controller;


import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.cart.model.Cart;
import com.hossam.ecommerce.cart.service.CartService;
import com.hossam.ecommerce.common.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
public class CartController extends GenericController<Cart> {

    @Autowired
    public CartController(CartService service) {
        super(service);
    }

    @GetMapping("/customer-carts/{customerId}")
    public List<Cart> getAllCustomerCarts(@PathVariable int customerId){
        return ((CartService) super.service).getAllCustomerCart(customerId);
    }

}
