package com.example.echoservice1.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "echo-service")
data class EchoServiceConfiguration(var prefix: String = "")