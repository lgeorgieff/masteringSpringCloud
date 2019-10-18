package com.example.echoservice.controller

import com.example.echoservice.configuration.EchoServiceConfiguration
import com.example.echoservice.domain.SimpleMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
class EchoController {
    @Autowired
    private lateinit var config: EchoServiceConfiguration

    @GetMapping("/echo/{message}", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun echo(@PathVariable message: String) = SimpleMessage("${config.prefix}: $message").toMono()
}