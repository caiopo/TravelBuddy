package br.com.caiopo.travelbuddy.model.entity

data class Country(
        val name: String, // TODO remove
        val flag: String,
        val region: String,
        val area: Float,
        val timezones: List<String>,
        val borders: List<String>,
        val translations: Map<String, String>,
        val population: Int,
        val currencies: List<Currency>
)

data class Currency(
        val code: String,
        val name: String,
        val symbol: String
)
