package com.cibertec.carsystemuser.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/loginSuccess").authenticated() // Protegemos esta ruta
                                .anyRequest().permitAll() // Permitir el acceso a otras rutas
                )
                .oauth2Login(oauth2Login ->
                        oauth2Login.defaultSuccessUrl("/loginSuccess") // Redirigir a /loginSuccess después del login exitoso
                )
                .logout(logout -> logout.logoutSuccessUrl("/logout"));

        return http.build();

    }
}

