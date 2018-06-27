package br.com.caiopo.travelbuddy.view.adapter

import br.com.caiopo.travelbuddy.App
import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ItemCountryBinding
import br.com.caiopo.travelbuddy.model.entity.Country
import br.com.caiopo.travelbuddy.view.getCurrentLocale
import com.ahmadrosid.svgloader.SvgLoader
import org.jetbrains.anko.AnkoLogger
import java.text.Collator

class CountriesAdapter(
        private val onClick: (Country) -> Unit
) : BindingAdapter<Country, ItemCountryBinding>(R.layout.item_country), AnkoLogger {

    override fun setItems(newItems: List<Country>) {
        val collator = Collator.getInstance(getCurrentLocale(App.context))

        val sortedItems = newItems.sortedWith(Comparator { o1, o2 ->
            collator.compare(o1.getLocalizedName(), o2.getLocalizedName())
        })

        super.setItems(sortedItems)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemCountryBinding>, position: Int, item: Country) {
        holder.binding.country = item
        holder.binding.onClick = onClick

        SvgLoader.pluck()
                .load(item.flag, holder.binding.imgFlag)
    }
}
