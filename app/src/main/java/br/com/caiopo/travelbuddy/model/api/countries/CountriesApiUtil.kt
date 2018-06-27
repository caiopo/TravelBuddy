package br.com.caiopo.travelbuddy.model.api.countries

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object CountriesApiUtil {
    private const val BASE_API_URL = "https://restcountries.eu/rest/v2/"

    val client by lazy {
        createClient()
    }

    private fun createClient(): CountriesApi {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_API_URL)
                .build()

        return retrofit.create(CountriesApi::class.java)
    }
}
