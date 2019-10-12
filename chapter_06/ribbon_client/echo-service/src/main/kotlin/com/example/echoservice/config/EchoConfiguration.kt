package com.example.echoservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@ConfigurationProperties(prefix = "echo-service")
@Configuration
@RefreshScope
data class EchoConfiguration(var usePrefix: Boolean = false)