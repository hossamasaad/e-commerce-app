package com.hossam.ecommerce.customer.controller;


import com.hossam.ecommerce.common.GenericController;
import com.hossam.ecommerce.customer.model.Customer;
import com.hossam.ecommerce.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController extends GenericController<Customer> {
    @Autowired
    public CustomerController(CustomerService customerService) {
        super(customerService);
    }
}
