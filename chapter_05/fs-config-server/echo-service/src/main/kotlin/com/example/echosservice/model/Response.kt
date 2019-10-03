package com.example.echosservice.model

data class Response<T>(val timestamp: Long = System.currentTimeMillis(), val message: T)
