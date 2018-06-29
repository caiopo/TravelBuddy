package br.com.caiopo.travelbuddy.view

import android.content.Context
import android.content.res.Resources
import android.databinding.BindingAdapter
import android.os.Build
import android.view.View
import android.widget.ImageView
import br.com.caiopo.travelbuddy.App
import br.com.caiopo.travelbuddy.model.entity.Country
import com.squareup.picasso.Picasso
import java.util.*


fun createMapUrl(country: Country?): String? {
    if (country == null) return null

    val lang = getCurrentLocale(App.context).language

    val width = (Resources.getSystem().displayMetrics.widthPixels * 0.9).toInt()
    val height = (width * 0.66).toInt()

    return "https://maps.googleapis.com/maps/api/staticmap?center=${country.name}&size=${width}x$height&language=$lang"
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

@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String?) {
    Picasso.get()
            .load(url ?: return)
            .into(view)
}
