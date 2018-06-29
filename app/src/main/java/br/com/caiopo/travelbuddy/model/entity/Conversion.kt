package br.com.caiopo.travelbuddy.model.entity

import com.google.gson.annotations.SerializedName

data class Conversion(
        val results: Map<String, Result>
) {
    val from: String
        get() =
            results.values.first().from

    val rates: Map<String, Float>
        get() =
            results.entries.associate { it.value.to to it.value.rate }
}


data class Result(
        @SerializedName("to") val from: String,
        @SerializedName("fr") val to: String,
        @SerializedName("val") val rate: Float
)
