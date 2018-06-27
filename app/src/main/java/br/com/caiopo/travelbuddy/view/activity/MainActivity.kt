package br.com.caiopo.travelbuddy.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ActivityMainBinding
import br.com.caiopo.travelbuddy.view.adapter.CountriesAdapter
import br.com.caiopo.travelbuddy.viewmodel.CountriesViewModel
import com.ahmadrosid.svgloader.SvgLoader

class MainActivity : BindingActivity<ActivityMainBinding>() {

    private val countriesAdapter = CountriesAdapter {
        Toast.makeText(this, it.getLocalizedName(), Toast.LENGTH_SHORT).show()
    }

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SvgLoader.pluck()
                .with(this)

        val viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        viewModel.countries.observe(this, Observer {
            binding.error = it?.error != null

            countriesAdapter.setItems(it?.value ?: return@Observer)
        })

        viewModel.loadCountries()

        binding.rvCountries.adapter = countriesAdapter

        val layoutManager = LinearLayoutManager(this)
        binding.rvCountries.layoutManager = layoutManager

    }


    override fun onDestroy() {
        super.onDestroy()
        SvgLoader.pluck().close()
    }
}
