package com.hossam.ecommerce.payment.model;

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
public class Payment extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "methodId")
    private PaymentMethod paymentMethod;

    private double amount;
    private String status;

}
