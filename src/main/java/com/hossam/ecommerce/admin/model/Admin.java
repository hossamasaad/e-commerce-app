package com.hossam.ecommerce.admin.model;

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
public class Admin extends GenericModel {

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(columnDefinition = "TEXT")
    private String password;

}
