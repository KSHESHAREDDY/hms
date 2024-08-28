package com.javatraining.demo.config;

import com.javatraining.demo.service.CustomUserDetailsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.requiresChannel(rcc -> rcc.anyRequest().requiresInsecure())
                .authorizeHttpRequests(ahc -> ahc
                        .requestMatchers("/hotel/atm", "/hotel/bank").authenticated()  // Require authentication for these URLs
                        .requestMatchers("/**").permitAll()  // Allow access to everything else
                )
                .csrf(csrf -> csrf.disable())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }


//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }

//    @Bean
//    public UserDetailsService userDetails() {
//        UserDetails shesha = User.withUsername("shesha").password("{noop}admin").build();
//        UserDetails manoj = User.withUsername("monoj").password("admin").build();
//        return new InMemoryUserDetailsManager(shesha, manoj);
//    }

    @Bean
    public UserDetailsService userDetails(DataSource dataSource) {
        return new CustomUserDetailsManager();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
