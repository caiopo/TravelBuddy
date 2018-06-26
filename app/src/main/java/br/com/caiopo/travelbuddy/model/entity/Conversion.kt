package br.com.caiopo.travelbuddy.model.entity

data class Conversion(
        val source: Country,
        val dest: Country,
        val rate: Double
)
