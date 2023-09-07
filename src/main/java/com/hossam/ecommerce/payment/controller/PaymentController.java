package com.hossam.ecommerce.payment.controller;


import com.hossam.ecommerce.payment.model.Payment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    @GetMapping("/{paymentId}")
    public Payment getPaymentById(@PathVariable int paymentId){
        return Payment.builder().build();
    }

    @PostMapping
    public Payment addPayment(@RequestBody Payment payment){
        return payment;
    }

    @PutMapping("/{paymentId}")
    public Payment updatePayment(@PathVariable int paymentId, @RequestBody Payment payment){
        return payment;
    }

    @DeleteMapping("/{paymentId}")
    public Payment deletePayment(@PathVariable int paymentId){
        return Payment.builder().build();
    }

}
