package com.hossam.ecommerce.order.model;


import com.hossam.ecommerce.cart.model.Cart;
import com.hossam.ecommerce.common.GenericModel;
import com.hossam.ecommerce.customer.model.Customer;
import com.hossam.ecommerce.payment.model.Payment;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
public class Order extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "paymentId")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

}
