package br.com.caiopo.travelbuddy.view

import br.com.caiopo.travelbuddy.model.entity.Country

fun createMapUrl(country: Country): String {
    return "https://maps.googleapis.com/maps/api/staticmap?center=${country.name}&size=450x300&language=pt"
}
