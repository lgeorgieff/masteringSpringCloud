package com.example.echoservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class EchoServiceApplication

fun main(args: Array<String>) {
    runApplication<EchoServiceApplication>(*args)
}