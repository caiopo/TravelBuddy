package br.com.caiopo.travelbuddy.util

data class ErrorWrapper<T>(
        val value: T? = null,
        val error: Throwable? = null
)
