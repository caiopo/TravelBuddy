package br.com.caiopo.travelbuddy.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.MenuItem
import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ActivityCountryBinding
import br.com.caiopo.travelbuddy.model.entity.Conversion
import br.com.caiopo.travelbuddy.model.entity.Country
import br.com.caiopo.travelbuddy.util.ErrorWrapper
import br.com.caiopo.travelbuddy.view.adapter.ConversionsAdapter
import br.com.caiopo.travelbuddy.viewmodel.ConversionViewModel
import br.com.caiopo.travelbuddy.viewmodel.CountriesViewModel
import com.ahmadrosid.svgloader.SvgLoader

class CountryActivity : BindingActivity<ActivityCountryBinding>() {

    companion object {
        val COUNTRY_CODE_KEY: String = CountryActivity::class.java.canonicalName + ".COUNTRY_CODE_KEY"
        val COUNTRY_NAME_KEY: String = CountryActivity::class.java.canonicalName + ".COUNTRY_NAME_KEY"
    }

    private val conversionsAdapter = ConversionsAdapter()

    override val layoutId: Int
        get() = R.layout.activity_country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loading = true

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.content?.rvConversions?.adapter = conversionsAdapter

        val countryCode = intent.getStringExtra(COUNTRY_CODE_KEY)
        title = intent.getStringExtra(COUNTRY_NAME_KEY)

        val countriesViewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        countriesViewModel.countries.observe(this, Observer {
            binding.error = it?.error != null

            binding.loading = !binding.error && it?.value == null

            val country = it?.value?.find { it.alpha3Code == countryCode }

            onCountryLoaded(country)
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        super.onDestroy()
        SvgLoader.pluck().close()
    }

    private fun onCountryLoaded(country: Country?) {
        binding.country = country

        if (country != null) {
            SvgLoader.pluck()
                    .with(this)
                    .load(country.flag, binding.backdrop)

            val conversionViewModel = ViewModelProviders.of(this).get(ConversionViewModel::class.java)

            conversionViewModel.getConversions("BRL", country.currencies.map { it.code.toUpperCase() })
                    .observe(this, Observer(this::onConversionLoaded))
        }
    }

    private fun onConversionLoaded(ewConversion: ErrorWrapper<Conversion>?) {
        val conversion = ewConversion?.value ?: return

        conversionsAdapter.from = conversion.from

        conversionsAdapter.setItems(conversion.rates.entries.toList())
    }
}
