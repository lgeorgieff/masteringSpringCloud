package com.example.prefixservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class PrefixServiceApplication

fun main(args: Array<String>) {
    runApplication<PrefixServiceApplication>(*args)
}