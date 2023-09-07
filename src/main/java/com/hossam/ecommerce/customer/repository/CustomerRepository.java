package com.hossam.ecommerce.customer.repository;

import com.hossam.ecommerce.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
