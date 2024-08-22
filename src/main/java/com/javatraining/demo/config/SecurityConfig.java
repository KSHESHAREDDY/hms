package com.javatraining.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security.authorizeHttpRequests((requests) -> requests.requestMatchers("/hotel/atm", "/hotel/bank").authenticated()
                                .requestMatchers("/**").permitAll())
//                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults()).build();
    }


}
