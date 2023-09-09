package com.hossam.ecommerce.common;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;


    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date modifiedAt;


}
