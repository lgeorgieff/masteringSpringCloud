package com.example.eurekaclientprogrammatically.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/api")
class ClientController {
    @Autowired
    private lateinit var mDiscoveryClient: DiscoveryClient

    @GetMapping("/services")
    fun services() = mDiscoveryClient.services.toMono()

    @GetMapping("/instances/{service-id}")
    fun instances(@PathVariable("service-id") serviceId: String) =
            mDiscoveryClient.getInstances(serviceId).toMono()
}