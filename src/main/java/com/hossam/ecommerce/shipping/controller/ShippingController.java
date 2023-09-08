package com.hossam.ecommerce.shipping.controller;


import com.hossam.ecommerce.common.GenericController;
import com.hossam.ecommerce.shipping.model.Shipping;
import com.hossam.ecommerce.shipping.service.ShippingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipping")
public class ShippingController extends GenericController<Shipping> {

    public ShippingController(ShippingService shippingService) {
        super(shippingService);
    }
}
