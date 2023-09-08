package com.hossam.ecommerce.product.model;


import com.hossam.ecommerce.category.model.Category;
import com.hossam.ecommerce.common.GenericModel;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product extends GenericModel {

    private String name;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    private double price;

}
