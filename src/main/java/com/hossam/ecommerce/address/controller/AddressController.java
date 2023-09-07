package com.hossam.ecommerce.address.controller;


import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddresses(){
        return addressService.getAddresses();
    }

    @GetMapping("/{addressId}")
    public Address getAddressById(@PathVariable int addressId){
        return addressService.getAddressById(addressId);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping
    public Address updateAddress(@RequestBody Address address){
        return addressService.updateAddress(address);
    }

    @DeleteMapping("/{studentId}")
    public void deleteAddress(@PathVariable int studentId){
        addressService.deleteAddressById(studentId);
    }

    @GetMapping("/customer-addresses/{customerId}")
    public List<Address> getAllCustomerAddresses(@PathVariable int customerId){
        return addressService.getAllCustomerAddresses(customerId);
    }


}
