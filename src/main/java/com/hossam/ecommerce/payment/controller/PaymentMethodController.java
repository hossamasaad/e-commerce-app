package com.hossam.ecommerce.payment.controller;

import com.hossam.ecommerce.payment.model.PaymentMethod;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment-method")
public class PaymentMethodController {

    @GetMapping("/{paymentMethodId}")
    public PaymentMethod getPaymentMethodById(@PathVariable int paymentMethodId){
        return PaymentMethod.builder().build();
    }

    @PostMapping
    public PaymentMethod addPaymentMethod(@RequestBody PaymentMethod paymentMethod){
        return paymentMethod;
    }

    @PutMapping("/{paymentMethodId}")
    public PaymentMethod updatePaymentMethod(@PathVariable int paymentMethodId, @RequestBody PaymentMethod paymentMethod){
        return paymentMethod;
    }

    @DeleteMapping("/{paymentMethodId}")
    public PaymentMethod deleteCustomer(@PathVariable int paymentMethodId){
        return PaymentMethod.builder().build();
    }


}
