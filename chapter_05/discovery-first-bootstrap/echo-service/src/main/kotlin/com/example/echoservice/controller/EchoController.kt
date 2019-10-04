package com.example.echoservice.controller

import com.example.echoservice.config.EchoServiceConfig
import com.example.echoservice.model.EchoResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/echo")
class EchoController {
    @Autowired
    private lateinit var config: EchoServiceConfig

    @GetMapping("/{message}", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun echoGet(@PathVariable message: String) = EchoResponse(message = "${config.prefix}$message").toMono()
}