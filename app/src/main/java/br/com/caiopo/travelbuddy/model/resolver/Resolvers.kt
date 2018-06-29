package br.com.caiopo.travelbuddy.model.resolver

object Resolvers {
    @JvmStatic
    val region by lazy { RegionResolver() }
}
