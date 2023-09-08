package com.hossam.ecommerce.category.model;



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
public class Category extends GenericModel {

    @Column(unique = true)
    private String categoryName;

    @Column(columnDefinition = "TEXT")
    private String description;

}
