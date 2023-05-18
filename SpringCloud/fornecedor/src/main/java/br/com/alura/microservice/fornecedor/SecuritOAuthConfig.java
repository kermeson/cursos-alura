package br.com.alura.microservice.fornecedor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecuritOAuthConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authz -> authz.anyRequest()
                .authenticated())
                .oauth2ResourceServer(oauth2 -> oauth2.opaqueToken());
        return http.build();
    }
}
