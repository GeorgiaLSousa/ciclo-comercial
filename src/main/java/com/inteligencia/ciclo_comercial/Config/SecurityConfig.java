package com.inteligencia.ciclo_comercial.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/revisao/atualizar-email", "/revisao/detalhes-territorio/{codigoTerritorio}", "/territorio/buscar-territorio","/territorio/lista-territorio", "/territorio/alterar-estado-territorio", "/css/**", "/imagens/**", "/JS/**").permitAll()
                    .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable()); // Disable CSRF for testing purposes

        return http.build();
    }
}