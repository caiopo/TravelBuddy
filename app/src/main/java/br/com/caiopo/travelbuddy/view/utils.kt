package br.com.caiopo.travelbuddy.view

import android.content.Context
import android.databinding.BindingAdapter
import android.os.Build
import android.view.View
import br.com.caiopo.travelbuddy.model.entity.Country
import java.util.*


fun createMapUrl(country: Country): String {
    return "https://maps.googleapis.com/maps/api/staticmap?center=${country.name}&size=450x300&language=pt"
}

fun getCurrentLocale(context: Context): Locale {
    val conf = context.resources.configuration

    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        conf.locales[0]
    } else {
        conf.locale
    }
}


@BindingAdapter("visibleIf")
fun visibleIf(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}
