package com.example.saml2example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/**").authenticated()  // Protege todas las rutas bajo /api/*
                        .requestMatchers("/dashboard", "/logged-out").permitAll()  // Permite acceso sin autenticación a estas rutas
                        .anyRequest().permitAll()  // Permite acceso sin autenticación a cualquier otra ruta
                )
                .saml2Login(saml2 -> saml2
                        .defaultSuccessUrl("/api/dashboard")  // Redirige a /api/dashboard después del login exitoso
                )
                .saml2Logout((saml2) -> saml2.logoutUrl("/logged-out")  // Elimina las cookies de sesión // Elimina las cookies de sesión // Redirige al dashboard después de logout
                );// Configuración para SAML2 Logout

        return http.build();
    }
}
