package com.example.echoservice.controller

import com.example.echoservice.config.EchoConfiguration
import com.example.echoservice.domain.SimpleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.ribbon.RibbonClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/api")
@RibbonClient(name = "prefixservice")
class EchoController {
    @Autowired
    private lateinit var config: EchoConfiguration

    @Autowired
    private lateinit var webClientBuilder: WebClient.Builder

    @GetMapping("/echo/{message}")
    fun echoGet(@PathVariable message: String, @RequestParam upperCase: Boolean = false): Mono<String> {
        return when (config.usePrefix) {
            true -> webClientBuilder
                .build()
                .get()
                .uri("http://prefixservice/api/prefix?upperCase={upperCase}", upperCase)
                .headers { it.setBasicAuth("prefix", "prefix") }
                .retrieve()
                .bodyToMono(SimpleResponse::class.java)
                .map { "${it.value}: $message" }
            else -> message.toMono()
        }
    }

    @Bean
    @LoadBalanced
    fun loadBalancedWebClientBuilder() = WebClient.builder()
}