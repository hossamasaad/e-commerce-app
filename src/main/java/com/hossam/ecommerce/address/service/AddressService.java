package com.hossam.ecommerce.address.service;


import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.address.repository.AddressRepository;
import com.hossam.ecommerce.admin.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
        address.setAddressId(0); // force to save
        address.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        address.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        return addressRepository.save(address);
    }

    public Address updateAddress(Address address){
        if (address.getAddressId() == 0) {
            throw new IllegalArgumentException("Address ID cannot be null");
        }

        Optional<Address> existingAdmin = addressRepository.findById(address.getAddressId());
        if (existingAdmin.isEmpty()) {
            throw new IllegalArgumentException("Admin with ID " + address.getAddressId() + " does not exist");
        }

        address.setModifiedAt(new Timestamp(System.currentTimeMillis()));
        return addressRepository.save(address);
    }

    public void deleteAddressById(int addressId){
        addressRepository.deleteById(addressId);
    }

    public List<Address> getAllCustomerAddresses(int customerId){
        return addressRepository.getAllCustomerAddresses(customerId);
    }

}
