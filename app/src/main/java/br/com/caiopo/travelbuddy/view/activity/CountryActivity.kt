package br.com.caiopo.travelbuddy.view.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.view.MenuItem
import br.com.caiopo.travelbuddy.R
import br.com.caiopo.travelbuddy.databinding.ActivityCountryBinding
import br.com.caiopo.travelbuddy.viewmodel.CountriesViewModel
import com.ahmadrosid.svgloader.SvgLoader

class CountryActivity : BindingActivity<ActivityCountryBinding>() {

    companion object {
        val COUNTRY_CODE_KEY: String = CountryActivity::class.java.canonicalName + ".COUNTRY_CODE_KEY"
        val COUNTRY_NAME_KEY: String = CountryActivity::class.java.canonicalName + ".COUNTRY_NAME_KEY"
    }

    override val layoutId: Int
        get() = R.layout.activity_country

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val countryCode = intent.getStringExtra(COUNTRY_CODE_KEY)
        title = intent.getStringExtra(COUNTRY_NAME_KEY)

        val viewModel = ViewModelProviders.of(this).get(CountriesViewModel::class.java)

        viewModel.countries.observe(this, Observer {
            binding.error = it?.error != null

            binding.loading = !binding.error && it?.value == null

            val country = it?.value?.find { it.alpha3Code == countryCode }

            binding.country = country

            if (country != null) {

                SvgLoader.pluck()
                        .with(this)
                        .load(country.flag, binding.backdrop)
            }

        })

        viewModel.loadCountries()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
