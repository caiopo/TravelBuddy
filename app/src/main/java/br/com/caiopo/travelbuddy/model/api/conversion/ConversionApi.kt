package br.com.caiopo.travelbuddy.model.api.conversion

import br.com.caiopo.travelbuddy.model.entity.Conversion
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ConversionApi {

    @GET("convert")
    fun getConversion(@Query("q") query: String): Call<Conversion>
}
