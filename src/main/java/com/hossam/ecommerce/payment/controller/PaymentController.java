package com.hossam.ecommerce.payment.controller;


import com.hossam.ecommerce.common.GenericController;
import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.payment.model.Payment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController extends GenericController<Payment> {

    public PaymentController(GenericService<Payment> service) {
        super(service);
    }
}
