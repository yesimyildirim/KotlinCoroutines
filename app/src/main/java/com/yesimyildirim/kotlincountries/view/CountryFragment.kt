package com.yesimyildirim.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yesimyildirim.kotlincoroutines.R
import com.yesimyildirim.kotlincoroutines.databinding.FragmentCountryBinding
import com.yesimyildirim.kotlincountries.view.CountryFragmentArgs


import com.yesimyildirim.kotlincountries.model.Country
import com.yesimyildirim.kotlincountries.util.downloadFromUrl
import com.yesimyildirim.kotlincountries.util.placeholderProgressBar
import com.yesimyildirim.kotlincountries.viewmodel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {
    private lateinit var viewModel : CountryViewModel
    private var countryUuid =0
    private lateinit var dataBinding: FragmentCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding=DataBindingUtil.inflate(inflater, R.layout.fragment_country,container,false)
        // Inflate the layout for this fragment
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            countryUuid = CountryFragmentArgs.fromBundle(
                it
            ).countryUuid
        }

        viewModel = ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuid)

        observeLiveData()
    }

    private fun observeLiveData(){
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer {country->
            country?.let{
                dataBinding.selectedCountry=country
                /*
                   countryName.text= country.countryName
                countryCapital.text=country.countryCapital
                countryCurrency.text=country.countryCurrency
                countryRegion.text=country.countryRegion
                countryLanguage.text=country.countryLanguage
                context?.let{
                    countryImage.downloadFromUrl(country.flag, placeholderProgressBar(it))
                }
                 */



            }
        })
    }

}
