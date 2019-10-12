package com.example.prefixservice.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
class SecurityConfig {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .authorizeExchange().pathMatchers("/actuator/info", "/actuator/health").permitAll()
            .and().authorizeExchange().pathMatchers("/**").authenticated()
            .and().httpBasic()
            .and().build()
    }

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService {
        val user = User
            .withUsername("prefix")
            .password("{noop}prefix")
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(user)
    }
}