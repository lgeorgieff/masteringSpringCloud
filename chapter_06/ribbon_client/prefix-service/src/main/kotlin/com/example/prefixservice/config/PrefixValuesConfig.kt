package com.example.prefixservice.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "prefix-service.prefix")
@RefreshScope
class PrefixValuesConfig {
    lateinit var values: List<String>

    fun randomPrefix() = values.random()
}