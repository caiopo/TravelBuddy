package br.com.caiopo.travelbuddy.view.adapter

import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ItemConversionBinding
import br.com.caiopo.travelbuddy.databinding.ItemTimezoneBinding
import org.jetbrains.anko.AnkoLogger

class TimezoneAdapter : BindingAdapter<String, ItemTimezoneBinding>(R.layout.item_timezone), AnkoLogger {

    override fun onBindViewHolder(holder: BindingViewHolder<ItemTimezoneBinding>, position: Int, item: String) {
        holder.binding.timezone = item
    }
}
