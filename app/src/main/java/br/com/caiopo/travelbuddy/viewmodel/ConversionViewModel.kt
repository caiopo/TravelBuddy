package br.com.caiopo.travelbuddy.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caiopo.travelbuddy.model.ConversionModel
import br.com.caiopo.travelbuddy.model.entity.Conversion

class ConversionViewModel : ViewModel() {

    private val conversionModel = ConversionModel()

    private val _conversion = MutableLiveData<List<Conversion>>()

    val conversion: LiveData<List<Conversion>>
        get() = _conversion

    fun setConversion(source: String) {
        conversionModel.setConversions(source, _conversion)
    }
}
