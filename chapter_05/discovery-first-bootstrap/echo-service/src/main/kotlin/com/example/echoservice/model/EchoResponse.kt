package com.example.echoservice.model

data class EchoResponse<T>(val timestamp: Long = System.currentTimeMillis(), val message: T)