import br.com.caiopo.travelbuddy.model.api.conversion.ConversionApi
import br.com.caiopo.travelbuddy.model.entity.Conversion
import retrofit2.Call

fun ConversionApi.getConversions(from: String, to: List<String>): Call<Conversion> {
    val query = to.joinToString(separator = ",") { "${from}_$it".toUpperCase() }

    return getConversion(query)
}
