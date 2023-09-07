package com.hossam.ecommerce.payment.repository;

import com.hossam.ecommerce.payment.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Integer> {
}
