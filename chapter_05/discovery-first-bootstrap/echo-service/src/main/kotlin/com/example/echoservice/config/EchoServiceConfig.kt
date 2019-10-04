package com.example.echoservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "echo-service")
class EchoServiceConfig {
    lateinit var prefix: String
}