package com.hossam.ecommerce.address.repository;

import com.hossam.ecommerce.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("SELECT a FROM Address a WHERE a.customer.id = :customerId")
    List<Address> getAllCustomerAddresses(int customerId);
}