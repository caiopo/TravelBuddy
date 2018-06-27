package br.com.caiopo.travelbuddy.view.adapter

import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ItemCountryBinding
import br.com.caiopo.travelbuddy.model.entity.Country
import br.com.caiopo.travelbuddy.view.createMapUrl
import com.squareup.picasso.Picasso

class CountriesAdapter : BindingAdapter<Country, ItemCountryBinding>(R.layout.item_country) {

    override fun onBindViewHolder(holder: BindingViewHolder<ItemCountryBinding>, position: Int, item: Country) {
        holder.binding.country = item

        Picasso.get()
                .load(createMapUrl(item))
                .into(holder.binding.imgFlag)
    }
}
