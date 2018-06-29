package br.com.caiopo.travelbuddy.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import br.com.caiopo.travelbuddy.model.api.conversion.ConversionApiUtil
import br.com.caiopo.travelbuddy.model.entity.Conversion
import br.com.caiopo.travelbuddy.util.ErrorWrapper
import br.com.caiopo.travelbuddy.util.RetrofitLiveData
import getConversions

class ConversionViewModel : ViewModel() {

    private val _conversion = RetrofitLiveData<Conversion>()

    private var from: String? = null
    private var to: List<String>? = null

    fun getConversions(from: String, to: List<String>): LiveData<ErrorWrapper<Conversion>> {
        if (this.from != from || this.to != to) {
            this.from = from
            this.to = to

            ConversionApiUtil.client.getConversions(from, to).enqueue(_conversion)
        }
        return _conversion
    }
}

