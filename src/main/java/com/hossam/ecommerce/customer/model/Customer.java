package com.hossam.ecommerce.customer.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String password;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date modifiedAt;

    public Customer(Integer customerId) {
        this.customerId = customerId;
    }
}
