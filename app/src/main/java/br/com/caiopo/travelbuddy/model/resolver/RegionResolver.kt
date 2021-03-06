package br.com.caiopo.travelbuddy.model.resolver

import br.com.caiopo.travelbuddy.R

class RegionResolver : BaseResolver<String>() {

    override fun getRes(item: String): Int {
        return when (item.toLowerCase()) {
            "americas" -> R.string.region_americas
            "africa" -> R.string.region_africa
            "asia" -> R.string.region_asia
            "oceania" -> R.string.region_oceania
            "europe" -> R.string.region_europe
            "polar" -> R.string.region_polar
            else -> R.string.empty
        }
    }
}
