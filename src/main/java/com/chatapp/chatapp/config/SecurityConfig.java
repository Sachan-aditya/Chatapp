package com.chatapp.chatapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 🔥 Disable CSRF for now (safe in dev mode)
                .authorizeHttpRequests()
                .requestMatchers("/api/**", "/ws/**", "/topic/**", "/app/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin() // Enables the login page
                .and()
                .httpBasic(); // Enables basic auth (for Postman)

        return http.build();
    }
}
