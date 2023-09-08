package com.hossam.ecommerce.cart.model;

import com.hossam.ecommerce.common.GenericModel;
import com.hossam.ecommerce.customer.model.Customer;
import jakarta.persistence.*;
import lombok.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    private String status;

}
