package com.hossam.ecommerce.address.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.hossam.ecommerce.common.GenericModel;
import com.hossam.ecommerce.customer.model.Customer;
import jakarta.persistence.*;
import lombok.*;


@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonIdentityReference(alwaysAsId = true)
    private Customer customer;

    private String postalCode;
    private String lineAddress;
    private String city;
    private String country;
}
