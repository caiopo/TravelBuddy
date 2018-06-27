package br.com.caiopo.travelbuddy.model.resolver

import android.support.annotation.StringRes
import br.com.caiopo.travelbuddy.R

object RegionResolver {

    @StringRes
    fun get(region: String): Int {
        return when (region.toLowerCase()) {
            "americas" -> R.string.region_americas
            "africa" -> R.string.region_africa
            "asia" -> R.string.region_asia
            "oceania" -> R.string.region_oceania
            "europe" -> R.string.region_europe
            else -> throw NoSuchElementException("no region with key '$region'")
        }
    }
}
