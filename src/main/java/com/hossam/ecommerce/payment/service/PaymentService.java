package com.hossam.ecommerce.payment.service;


import com.hossam.ecommerce.common.GenericService;
import com.hossam.ecommerce.payment.model.Payment;
import com.hossam.ecommerce.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService extends GenericService<Payment> {

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        super(paymentRepository);
    }
}
