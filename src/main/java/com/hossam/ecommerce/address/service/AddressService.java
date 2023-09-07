package com.hossam.ecommerce.address.service;


import com.hossam.ecommerce.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // TODO : Get address by id address

    // TODO : Create new Address

    // TODO : Update Address

    // TODO : Delete Address by ID

    // TODO : Get List of customer Address by customerId

    // TODO : Get Customer by address Id

    // TODO : Get Postal code by id address

    // TODO : Update Postal code by id address

    // TODO : Get line address by id address

    // TODO : Update line address by id address

    // TODO : Get city by id address

    // TODO : Update city by id address

    // TODO : Get country by id address

    // TODO : Update country by id address

}
