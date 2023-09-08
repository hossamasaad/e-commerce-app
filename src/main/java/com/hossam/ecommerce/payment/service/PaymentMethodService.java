package com.hossam.ecommerce.payment.service;

import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.payment.model.PaymentMethod;
import com.hossam.ecommerce.payment.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodService extends GenericService<PaymentMethod> {

    @Autowired
    public PaymentMethodService(PaymentMethodRepository paymentMethodRepository) {
        super(paymentMethodRepository);
    }
}
