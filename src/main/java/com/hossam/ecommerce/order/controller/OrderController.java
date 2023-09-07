package com.hossam.ecommerce.order.controller;


import com.hossam.ecommerce.order.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @GetMapping("/{orderId}")
    public Order getCustomerById(@PathVariable int orderId){
        return Order.builder().build();
    }

    @PostMapping
    public Order addCustomer(@RequestBody Order order){
        return order;
    }


    @PutMapping("/{orderId}")
    public Order updateCustomer(@PathVariable int orderId, @RequestBody Order order){
        return order;
    }

    @DeleteMapping("/{orderId}")
    public Order deleteCustomer(@PathVariable int orderId){
        return Order.builder().build();
    }

}
