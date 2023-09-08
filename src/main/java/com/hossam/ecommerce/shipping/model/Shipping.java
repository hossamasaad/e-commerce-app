package com.hossam.ecommerce.shipping.model;

import com.hossam.ecommerce.address.model.Address;
import com.hossam.ecommerce.common.GenericModel;
import com.hossam.ecommerce.order.model.Order;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Shipping extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    private double shippingCost;
    private String status;

}
