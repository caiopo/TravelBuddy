package br.com.caiopo.travelbuddy.model.entity

import br.com.caiopo.travelbuddy.App
import br.com.caiopo.travelbuddy.view.getCurrentLocale

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
) {

    fun getLocalizedName(): String {
        val locale = getCurrentLocale(App.context)

        if (locale.language.toLowerCase() == "pt") {
            return translations["br"] ?: name
        }

        return name
    }
}

data class Currency(
        val code: String,
        val name: String,
        val symbol: String
)
