package com.hossam.ecommerce.address.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.hossam.ecommerce.customer.model.Customer;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @JsonIdentityReference(alwaysAsId = true)
    private Customer customer;

    private String postalCode;
    private String lineAddress;
    private String city;
    private String country;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date modifiedAt;

}
