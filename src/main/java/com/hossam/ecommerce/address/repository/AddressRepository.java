package com.hossam.ecommerce.address.repository;

import com.hossam.ecommerce.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
