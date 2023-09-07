package com.hossam.ecommerce.shipping.repository;

import com.hossam.ecommerce.shipping.model.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Integer> {
}
