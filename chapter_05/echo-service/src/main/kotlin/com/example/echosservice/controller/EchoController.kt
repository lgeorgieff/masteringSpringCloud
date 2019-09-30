package com.example.echosservice.controller

import com.example.echosservice.config.EchoServiceConfig
import com.example.echosservice.config.TimestampUnit
import com.example.echosservice.model.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import javax.validation.constraints.NotBlank

@RestController
@RequestMapping("/echo")
class EchoController {
    @Autowired
    private lateinit var config: EchoServiceConfig

    @GetMapping("/{message}", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun echoGet(@PathVariable @NotBlank message: String)
            = Response(timestamp = getTimestamp(), message = message)

    @PostMapping("/", consumes = [MediaType.APPLICATION_JSON_UTF8_VALUE],
            produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun echoPost(@RequestBody @NotBlank message: Mono<String>)
            = message.map { Response(timestamp = getTimestamp(), message = it) }

    private fun getTimestamp() = when(config.timestamp) {
        TimestampUnit.SECONDS -> System.currentTimeMillis() / 1000
        else -> System.currentTimeMillis()
    }
}