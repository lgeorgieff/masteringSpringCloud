package com.example.echoservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "echo-service")
@RefreshScope
class EchoServiceConfig {
    lateinit var prefix: String
}