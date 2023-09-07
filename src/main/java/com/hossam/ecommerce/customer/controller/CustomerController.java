package com.hossam.ecommerce.customer.controller;


import com.hossam.ecommerce.customer.model.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId){
        return Customer.builder().build();
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customer;
    }


    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){
        return customer;
    }

    @DeleteMapping("/{customerId}")
    public Customer deleteCustomer(@PathVariable int customerId){
        return Customer.builder().build();
    }

}
