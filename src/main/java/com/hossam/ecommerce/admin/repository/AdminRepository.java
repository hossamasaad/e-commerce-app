package com.hossam.ecommerce.admin.repository;

import com.hossam.ecommerce.admin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Optional<Admin> findByEmail(String adminEmail);

}
