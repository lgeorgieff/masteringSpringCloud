package com.example.authorizationserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer

@SpringBootApplication
@EnableAuthorizationServer
class AuthorizationServerApplication

fun main(args: Array<String>) {
	runApplication<AuthorizationServerApplication>(*args)
}
