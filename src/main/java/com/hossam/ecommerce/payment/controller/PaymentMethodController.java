package com.hossam.ecommerce.payment.controller;

import com.hossam.ecommerce.common.GenericController;
import com.hossam.ecommerce.payment.model.PaymentMethod;
import com.hossam.ecommerce.payment.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment-method")
public class PaymentMethodController extends GenericController<PaymentMethod> {

    @Autowired
    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        super(paymentMethodService);
    }
}
