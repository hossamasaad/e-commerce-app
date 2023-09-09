package com.hossam.ecommerce.auth.config;

import com.hossam.ecommerce.auth.repo.AdminTokenRepository;
import com.hossam.ecommerce.auth.repo.CustomerTokenRepository;
import com.hossam.ecommerce.auth.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Primary
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AdminTokenRepository adminTokenRepository;
    private final CustomerTokenRepository customerTokenRepository;

    @Autowired
    public JwtAuthFilter(JwtService jwtService, UserDetailsService userDetailsService, AdminTokenRepository adminTokenRepository, CustomerTokenRepository customerTokenRepository) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
        this.adminTokenRepository = adminTokenRepository;
        this.customerTokenRepository = customerTokenRepository;
    }

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain
    ) throws ServletException, IOException {

        if (request.getServletPath().contains("/api/v1/auth")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String jwtToken = authHeader.substring(7);
        final String email = jwtService.extractEmail(jwtToken);

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            boolean isTokenValid = isTokenValidForUser(jwtToken, userDetails);

            if (isTokenValid) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }

    private boolean isTokenValidForUser(String jwtToken, UserDetails userDetails) {
        boolean isAdminTokenValid = adminTokenRepository
                .findByToken(jwtToken)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);

        boolean isCustomerTokenValid = customerTokenRepository
                .findByToken(jwtToken)
                .map(t -> !t.isExpired() && !t.isRevoked())
                .orElse(false);

        return jwtService.isTokenValid(jwtToken, userDetails) && (isAdminTokenValid || isCustomerTokenValid);
    }

}
