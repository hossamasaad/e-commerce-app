package com.hossam.ecommerce.order.controller;


import com.hossam.ecommerce.common.GenericController;
import com.hossam.ecommerce.order.model.Order;
import com.hossam.ecommerce.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
public class OrderController extends GenericController<Order> {
    @Autowired
    public OrderController(OrderService service) {
        super(service);
    }
}
