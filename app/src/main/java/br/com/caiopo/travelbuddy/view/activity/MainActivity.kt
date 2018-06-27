package br.com.caiopo.travelbuddy.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ActivityMainBinding
import br.com.caiopo.travelbuddy.view.adapter.CountriesAdapter
import br.com.caiopo.travelbuddy.viewmodel.CountriesViewModel

class MainActivity : BindingActivity<ActivityMainBinding>() {

    private val countriesAdapter = CountriesAdapter()

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        viewModel.countries.observe(this, Observer {
            binding.error = it?.error != null

            countriesAdapter.data = it?.value ?: return@Observer
        })

        viewModel.loadCountries()

        binding.rvCountries.adapter = countriesAdapter

        val layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        binding.rvCountries.layoutManager = layoutManager

    }
}
