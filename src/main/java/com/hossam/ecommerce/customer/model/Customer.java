package com.hossam.ecommerce.customer.model;

import com.hossam.ecommerce.common.GenericModel;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Customer extends GenericModel {

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String password;


    public Customer(Integer id) {
        super.id = id;
    }
}
