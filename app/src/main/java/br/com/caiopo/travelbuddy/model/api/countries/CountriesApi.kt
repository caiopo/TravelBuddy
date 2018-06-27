package br.com.caiopo.travelbuddy.model.api.countries

import br.com.caiopo.travelbuddy.model.entity.Country
import retrofit2.Call
import retrofit2.http.GET

interface CountriesApi {

    @get:GET("all")
    val countries: Call<List<Country>>
}
