package com.hossam.ecommerce.shipping.service;


import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.shipping.model.Shipping;
import com.hossam.ecommerce.shipping.repository.ShippingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShippingService extends GenericService<Shipping> {

    public ShippingService(ShippingRepository shippingRepository) {
        super(shippingRepository);
    }
}
