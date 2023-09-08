package com.hossam.ecommerce.cart.model;


import com.hossam.ecommerce.common.GenericModel;
import com.hossam.ecommerce.product.model.Product;
import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartItem extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;


}
