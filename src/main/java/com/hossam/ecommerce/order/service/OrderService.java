package com.hossam.ecommerce.order.service;

import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.order.model.Order;
import com.hossam.ecommerce.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends GenericService<Order> {
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        super(orderRepository);
    }
}
