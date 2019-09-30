package com.example.echosservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EchoServiceApplication

fun main(args: Array<String>) {
	runApplication<EchoServiceApplication>(*args)
}
