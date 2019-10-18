package com.example.echoservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EchoService1Application

fun main(args: Array<String>) {
    runApplication<EchoService1Application>(*args)
}