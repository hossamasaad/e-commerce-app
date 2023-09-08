package com.hossam.ecommerce.customer.service;

import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.customer.model.Customer;
import com.hossam.ecommerce.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends GenericService<Customer> {

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        super(customerRepository);
    }

}
