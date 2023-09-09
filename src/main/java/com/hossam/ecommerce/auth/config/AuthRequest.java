package com.hossam.ecommerce.auth.config;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequest {
    private String email;
    String password;
    private int role; // 0 -> admin  1 -> Customer
}