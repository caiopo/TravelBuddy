package br.com.caiopo.travelbuddy.view.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

abstract class BindingAdapter<T, B>(
        private val layoutId: Int
) : RecyclerView.Adapter<BindingViewHolder<B>>() where B : ViewDataBinding {

    protected var data: List<T> = emptyList()

    open fun setItems(newItems: List<T>) {
        data = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<B> {
        val inflater = LayoutInflater.from(parent.context)

        val binding: B = DataBindingUtil.inflate(inflater, layoutId, parent, false)

        return BindingViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int) {
        onBindViewHolder(holder, position, data[position])
    }

    abstract fun onBindViewHolder(holder: BindingViewHolder<B>, position: Int, item: T)
}

class BindingViewHolder<B>(val binding: B) :
        RecyclerView.ViewHolder(binding.root) where B : ViewDataBinding {
}
