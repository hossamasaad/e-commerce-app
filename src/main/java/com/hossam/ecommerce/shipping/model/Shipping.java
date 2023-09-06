package com.hossam.ecommerce.shipping.model;

import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.order.model.Order;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shippingId;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    private double shippingCost;
    private String status;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date shippingDate;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date deliveryDate;

}
