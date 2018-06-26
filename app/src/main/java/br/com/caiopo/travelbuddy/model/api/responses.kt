package br.com.caiopo.travelbuddy.model.api

data class Response(
        val results: Map<String, Result>
)

data class Result(
        val id: String,
        val rate: Double,
        val to: String,
        val fr: String
)
