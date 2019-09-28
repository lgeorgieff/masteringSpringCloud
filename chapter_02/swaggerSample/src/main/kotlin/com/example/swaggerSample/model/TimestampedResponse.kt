package com.example.swaggerSample.model

data class TimestampedResponse<T>(val timestamp: Long = System.currentTimeMillis(), val message: T)