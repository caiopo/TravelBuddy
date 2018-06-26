package br.com.caiopo.travelbuddy.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ConversionApiUtil {
    private const val BASE_API_URL = "http://free.currencyconverterapi.com/api/v5/"


    val client by lazy {
        createClient()
    }

    private fun createClient(): ConversionApi {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_API_URL)
                .build()

        return retrofit.create(ConversionApi::class.java)
    }
}
