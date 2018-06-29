package br.com.caiopo.travelbuddy.view.adapter

import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ItemConversionBinding
import org.jetbrains.anko.AnkoLogger

class ConversionsAdapter : BindingAdapter<Map.Entry<String, Float>, ItemConversionBinding>(R.layout.item_conversion), AnkoLogger {

    lateinit var from: String

    override fun onBindViewHolder(holder: BindingViewHolder<ItemConversionBinding>, position: Int, item: Map.Entry<String, Float>) {
        holder.binding.from = from
        holder.binding.to = item.key
        holder.binding.rate = item.value
    }
}
