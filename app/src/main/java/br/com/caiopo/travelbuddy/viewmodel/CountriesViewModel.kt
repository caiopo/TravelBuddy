package br.com.caiopo.travelbuddy.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import br.com.caiopo.travelbuddy.model.api.countries.CountriesApiUtil
import br.com.caiopo.travelbuddy.model.entity.Country
import br.com.caiopo.travelbuddy.util.ErrorWrapper
import br.com.caiopo.travelbuddy.util.RetrofitLiveData

class CountriesViewModel : ViewModel() {

    private val _countries = RetrofitLiveData<List<Country>>()

    val countries: LiveData<ErrorWrapper<List<Country>>>
        get() = _countries

    fun loadCountries() {
        CountriesApiUtil.client.countries.enqueue(_countries)
    }
}
