package br.com.caiopo.travelbuddy.model.entity

import br.com.caiopo.travelbuddy.R

object Countries {
    val countries = mapOf(
            "BRL" to Country(name = R.string.country_bra, currency = "BRL"),
            "USD" to Country(name = R.string.country_usa, currency = "USD")
    )

    val currencies by lazy {
        countries.map { it.value.currency }
    }
}
