package br.com.caiopo.travelbuddy.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ActivityMainBinding
import br.com.caiopo.travelbuddy.viewmodel.CountriesViewModel

class MainActivity : BindingActivity<ActivityMainBinding>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        viewModel.countries.observe(this, Observer {
            binding.error = it?.error != null

        })

        viewModel.loadCountries()
    }
}
