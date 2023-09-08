package com.hossam.ecommerce.address.controller;


import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.address.service.AddressService;
import com.hossam.ecommerce.common.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController extends GenericController<Address> {

    @Autowired
    public AddressController(AddressService addressService) {
        super(addressService);
    }


    @GetMapping("/customer-addresses/{customerId}")
    public List<Address> getAllCustomerAddresses(@PathVariable int customerId){
        return ((AddressService) super.service).getAllCustomerAddresses(customerId);
    }

}
