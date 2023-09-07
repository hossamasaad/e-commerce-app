package com.hossam.ecommerce.address.service;


import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.address.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(int addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("Address not found with id: " + addressId));
    }

    public Address createAddress(Address address){
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address){
        return addressRepository.save(address);
    }

    public void deleteAddressById(int addressId){
        addressRepository.deleteById(addressId);
    }

    public List<Address> getAllCustomerAddresses(int customerId){
        return addressRepository.getAllCustomerAddresses(customerId);
    }

}
