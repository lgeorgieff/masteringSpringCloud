package com.example.swaggerSample.controller

import com.example.swaggerSample.model.TimestampedResponse
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import javax.validation.constraints.NotBlank
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.toMono

@RestController
@RequestMapping("/api")
class HelloController {
    @GetMapping("/hello/{name}", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("Generate a hello message", response = TimestampedResponse::class)
    @ApiResponses(
            ApiResponse(code = 500, message = "Internal server error"),
            ApiResponse(code = 404, message = "If name is empty")
    )
    fun sayHello(
        @ApiParam("Some name for the greetings message", name = "name", example = "John",
   required = true, allowEmptyValue = false) @PathVariable @NotBlank name: String
    ) =
            TimestampedResponse(message = "Hello $name!").toMono()

    @GetMapping("/hello-world", produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    @ApiOperation("Generate a hello world message", response = TimestampedResponse::class)
    @ApiResponses(ApiResponse(code = 500, message = "Internal server error"))
    fun sayHelloWorld() = TimestampedResponse(message = "Hello World!").toMono()
}