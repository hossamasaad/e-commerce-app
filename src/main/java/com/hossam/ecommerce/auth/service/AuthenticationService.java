package com.hossam.ecommerce.auth.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hossam.ecommerce.admin.model.Admin;
import com.hossam.ecommerce.admin.repository.AdminRepository;
import com.hossam.ecommerce.admin.service.AdminService;
import com.hossam.ecommerce.auth.config.AuthRequest;
import com.hossam.ecommerce.auth.config.AuthResponse;
import com.hossam.ecommerce.auth.config.RegisterRequest;
import com.hossam.ecommerce.auth.model.AdminToken;
import com.hossam.ecommerce.auth.model.CustomerToken;
import com.hossam.ecommerce.auth.model.TokenType;
import com.hossam.ecommerce.auth.repo.AdminTokenRepository;
import com.hossam.ecommerce.auth.repo.CustomerTokenRepository;
import com.hossam.ecommerce.customer.model.Customer;
import com.hossam.ecommerce.customer.repository.CustomerRepository;
import com.hossam.ecommerce.customer.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class AuthenticationService {

    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;
    private final AdminTokenRepository adminTokenRepository;
    private final CustomerTokenRepository customerTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthenticationService(AdminRepository adminRepository, CustomerRepository customerRepository, AdminService adminService, CustomerService customerService, AdminTokenRepository adminTokenRepository, CustomerTokenRepository customerTokenRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
        this.adminTokenRepository = adminTokenRepository;
        this.customerTokenRepository = customerTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @Transactional
    public AuthResponse register(RegisterRequest request) {
        Admin savedAdmin;
        if (request.getRole() == 0) { // admin
            Admin admin = Admin.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword())).build();

            admin.setId(0);
            admin.setModifiedAt(new Timestamp(System.currentTimeMillis()));
            admin.setCreatedAt(new Timestamp(System.currentTimeMillis()));

            savedAdmin = adminRepository.save(admin);
            String jwtToken = jwtService.generateToken(admin);
            String refreshToken = jwtService.generateRefreshToken(admin);

            saveAdminToken(savedAdmin, jwtToken);
            return new AuthResponse(jwtToken, refreshToken);
        } else if (request.getRole() == 1) { // customer
            Customer customer = Customer.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword())).build();

            customer.setId(0);
            customer.setModifiedAt(new Timestamp(System.currentTimeMillis()));
            customer.setCreatedAt(new Timestamp(System.currentTimeMillis()));

            Customer savedCustomer = customerRepository.save(customer);
            System.out.println(savedCustomer);

            String jwtToken = jwtService.generateToken(customer);
            String refreshToken = jwtService.generateRefreshToken(customer);

            saveCustomerToken(savedCustomer, jwtToken);
            return new AuthResponse(jwtToken, refreshToken);
        } else {
            throw new DataIntegrityViolationException("There is no role = " + request.getRole() + ", Admin => 0, Customer => 1");
        }
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        if (request.getRole() == 0) {
            Admin admin = adminRepository.findByEmail(request.getEmail()).orElseThrow(
                    () -> new DataIntegrityViolationException("Admin Not Found!")
            );

            String jwtToken = jwtService.generateToken(admin);
            String refreshToken = jwtService.generateRefreshToken(admin);

            revokeAllAdminTokens(admin);
            saveAdminToken(admin, jwtToken);

            return new AuthResponse(jwtToken, refreshToken);
        }
        else if (request.getRole() == 1) {
            Customer customer = customerRepository.findByEmail(request.getEmail()).orElseThrow(
                    () -> new DataIntegrityViolationException("Customer Not Found!")
            );
            String jwtToken = jwtService.generateToken(customer);
            String refreshToken = jwtService.generateRefreshToken(customer);

            revokeAllCustomerTokens(customer);
            saveCustomerToken(customer, jwtToken);

            return new AuthResponse(jwtToken, refreshToken);
        }
        else {
            throw new DataIntegrityViolationException("There is no role = " + request.getRole() + ", Admin => 0, Customer => 1");
        }
    }

    private void revokeAllAdminTokens(Admin admin) {
        var validTokens = adminTokenRepository.findAllValidTokenByAdmin(admin.getId());

        if (validTokens.isEmpty())
            return;

        validTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        adminTokenRepository.saveAll(validTokens);
    }

    private void revokeAllCustomerTokens(Customer customer) {
        var validTokens = customerTokenRepository.findAllValidTokenByCustomer(customer.getId());

        if (validTokens.isEmpty())
            return;

        validTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });

        customerTokenRepository.saveAll(validTokens);
    }

    private void saveAdminToken(Admin admin, String jwtToken) {
        AdminToken token = AdminToken.builder()
                .admin(admin)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        adminTokenRepository.save(token);
    }

    private void saveCustomerToken(Customer customer, String jwtToken) {
        CustomerToken token = CustomerToken.builder()
                .customer(customer)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();

        customerTokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        final String refreshToken = authHeader.substring(7);
        final String email = jwtService.extractEmail(refreshToken);

        if (email == null) {
            return;
        }

        Optional<Admin> optionalAdmin = adminRepository.findByEmail(email);
        if (optionalAdmin.isPresent() && jwtService.isTokenValid(refreshToken, optionalAdmin.get())) {
            Admin admin = optionalAdmin.get();
            String accessToken = jwtService.generateToken(admin);
            revokeAllAdminTokens(admin);
            saveAdminToken(admin, accessToken);
            writeAuthResponse(response, accessToken, refreshToken);
            return;
        }

        Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        if (optionalCustomer.isPresent() && jwtService.isTokenValid(refreshToken, optionalCustomer.get())) {
            Customer customer = optionalCustomer.get();
            String accessToken = jwtService.generateToken(customer);
            revokeAllCustomerTokens(customer);
            saveCustomerToken(customer, accessToken);
            writeAuthResponse(response, accessToken, refreshToken);
            return;
        }

        throw new DataIntegrityViolationException("Email Not Found!");
    }

    private void writeAuthResponse(HttpServletResponse response, String accessToken, String refreshToken) throws IOException {
        try (OutputStream outputStream = response.getOutputStream()) {
            AuthResponse authResponse = new AuthResponse(accessToken, refreshToken);
            new ObjectMapper().writeValue(outputStream, authResponse);
        }
    }

}