package com.example.auth.config;

import com.example.auth.service.MyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
        Spring Security:
            Intercepts every HTTP request
            Passes it through this filter chain
            Allows or blocks the request

        For this application:
            Disable CSRF
            Allow anyone to access /auth/**
            Require authentication for all other requests
            Authenticate users using my custom UserDetailsService
            Use HTTP Basic authentication”
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security,
                                                   MyUserDetailsService userDetailsService) {
        security.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req -> {
                    req.requestMatchers("/api/v1/auth/**").permitAll();
                    req.anyRequest().authenticated();
                }).userDetailsService(userDetailsService)
                .httpBasic(Customizer.withDefaults());
        return security.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) {
        return configuration.getAuthenticationManager();
    }

    /*
        UserDetailsService is a Spring-managed bean and must
        be injected, never instantiated manually.
     */
//    public UserDetailsService userDetailsService() {
//        return new MyUserDetailsService();
//    }
}
