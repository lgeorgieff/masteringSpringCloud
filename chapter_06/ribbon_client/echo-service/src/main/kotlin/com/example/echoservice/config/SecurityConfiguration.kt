package com.example.echoservice.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
class SecurityConfiguration {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
            .authorizeExchange().pathMatchers("/actuator/info", "/actuator/health", "/actuator/refresh").permitAll()
            .and().authorizeExchange().pathMatchers("/**").authenticated()
            .and().httpBasic()
            .and().csrf().disable()
            .build()
    }

    @Bean
    fun userDetailsService(): MapReactiveUserDetailsService {
        val user = User
            .withUsername("echo")
            .password("{noop}echo")
            .roles("USER")
            .build()
        return MapReactiveUserDetailsService(user)
    }
}