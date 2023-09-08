package com.hossam.ecommerce.address.service;


import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.address.repository.AddressRepository;
import com.hossam.ecommerce.common.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService extends GenericService<Address> {

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
    }

    public List<Address> getAllCustomerAddresses(int customerId){
        return ((AddressRepository) super.repo).getAllCustomerAddresses(customerId);
    }

}
