package com.example.gateway.configuration

import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class EchoRoutes {
    @Bean
    fun customRouteLocator(builder: RouteLocatorBuilder) = builder.routes()
        .route("echo-service-3") { r ->
            r.path("/echo/3/{message}")
                .filters { it.rewritePath("/echo/3/(?<message>)", "/echo/\${message}") }
                .uri("lb://echo-service-3")
        }
        .build()
}