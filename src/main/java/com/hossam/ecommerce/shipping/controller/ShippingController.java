package com.hossam.ecommerce.shipping.controller;


import com.hossam.ecommerce.shipping.model.Shipping;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingController {

    @GetMapping("/{shippingId}")
    public Shipping getShippingById(@PathVariable int shippingId){
        return Shipping.builder().build();
    }

    @PostMapping
    public Shipping addShipping(@RequestBody Shipping shipping){
        return shipping;
    }

    @PutMapping("/{shippingId}")
    public Shipping updateShipping(@PathVariable int shippingId, @RequestBody Shipping shipping){
        return shipping;
    }

    @DeleteMapping("/{shippingId}")
    public Shipping deleteShipping(@PathVariable int shippingId){
        return Shipping.builder().build();
    }

}
