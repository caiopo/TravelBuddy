package br.com.caiopo.travelbuddy.model.api;

import br.com.caiopo.travelbuddy.model.entity.Conversion;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConversionApi {

    @GET("/convert?q={query}")
    Call<Conversion> getConversion(@Path("query") String query);
}
