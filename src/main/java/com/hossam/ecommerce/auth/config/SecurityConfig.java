package com.hossam.ecommerce.auth.config;

import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    private final Filter jwtAuthenticationFilter;
    private final AuthenticationProvider adminAuthenticationProvider;
    private final AuthenticationProvider customerAuthenticationProvider;

    public SecurityConfig(Filter jwtAuthenticationFilter, AuthenticationProvider adminAuthenticationProvider, AuthenticationProvider customerAuthenticationProvider) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.adminAuthenticationProvider = adminAuthenticationProvider;
        this.customerAuthenticationProvider = customerAuthenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception {

        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/api/v1/cart/**").authenticated()
                                .requestMatchers("/api/v1/address/**").authenticated()
                                .requestMatchers("/api/v1/cart/**").authenticated()
                                .requestMatchers("/api/v1/cart-item/**").authenticated()
                                .requestMatchers("/api/v1/category/**").authenticated()
                                .requestMatchers("/api/v1/customer/**").authenticated()
                                .requestMatchers("/api/v1/order/**").authenticated()
                                .requestMatchers("/api/v1/payment/**").authenticated()
                                .requestMatchers("/api/v1/payment-method/**").authenticated()
                                .requestMatchers("/api/v1/product/**").authenticated()
                                .requestMatchers("/api/v1/shipping/**").authenticated()

                )
                .authorizeHttpRequests(
                        auth -> auth.requestMatchers("/api/v1/auth/**").permitAll()
                )
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(adminAuthenticationProvider)
                .authenticationProvider(customerAuthenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
