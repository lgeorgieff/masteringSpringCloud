package com.example.prefixservice.controller

import com.example.prefixservice.config.PrefixValuesConfig
import com.example.prefixservice.model.SimpleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/api")
class PrefixController {

    @Autowired
    private lateinit var config: PrefixValuesConfig

    private fun selectPrefix(upperCase: Boolean) = config.randomPrefix().run {
        when (upperCase) {
            true -> this.toUpperCase()
            false -> this
        }
    }

    @GetMapping("/prefix")
    fun getPrefix(@RequestParam upperCase: Boolean = false) = SimpleResponse(selectPrefix(upperCase)).toMono()
}