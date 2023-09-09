package com.hossam.ecommerce.auth.service;

import com.hossam.ecommerce.auth.model.AdminToken;
import com.hossam.ecommerce.auth.model.CustomerToken;
import com.hossam.ecommerce.auth.repo.AdminTokenRepository;
import com.hossam.ecommerce.auth.repo.CustomerTokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
public class LogoutService implements LogoutHandler {


    private final AdminTokenRepository adminTokenRepository;
    private final CustomerTokenRepository customerTokenRepository;

    public LogoutService(AdminTokenRepository adminTokenRepository, CustomerTokenRepository customerTokenRepository) {
        this.adminTokenRepository = adminTokenRepository;
        this.customerTokenRepository = customerTokenRepository;
    }


    @Override
    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null ||!authHeader.startsWith("Bearer "))
            return;

        final String jwt = authHeader.substring(7);
        AdminToken storedAdminToken = adminTokenRepository.findByToken(jwt).orElse(null);
        if (storedAdminToken != null){
            storedAdminToken.setExpired(true);
            storedAdminToken.setRevoked(true);
            adminTokenRepository.save(storedAdminToken);
            SecurityContextHolder.clearContext();
            return;
        }

        CustomerToken storedCustomerToken = customerTokenRepository.findByToken(jwt).orElse(null);
        if (storedCustomerToken != null){
            storedCustomerToken.setExpired(true);
            storedCustomerToken.setRevoked(true);
            customerTokenRepository.save(storedCustomerToken);
            SecurityContextHolder.clearContext();
            return;
        }

        throw new DataIntegrityViolationException("Token is Invalid!");
    }
}
