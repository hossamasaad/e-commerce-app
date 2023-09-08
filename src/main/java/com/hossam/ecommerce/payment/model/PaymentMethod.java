package com.hossam.ecommerce.payment.model;

import com.hossam.ecommerce.common.GenericModel;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentMethod extends GenericModel {

    @Column(unique = true)
    private String methodName;
    private String type;

}
