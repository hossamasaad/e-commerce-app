package com.hossam.ecommerce.category.repository;

import com.hossam.ecommerce.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
