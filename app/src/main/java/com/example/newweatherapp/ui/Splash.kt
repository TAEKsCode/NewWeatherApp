package com.example.newweatherapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.newweatherapp.R
import com.example.newweatherapp.model.WeatherViewModel

class Splash : Fragment() {

    private val viewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewModel.isLoading.observe(viewLifecycleOwner, {
            if (it) {
                findNavController().navigate(R.id.action_splash_to_weatherFragment)
                //Toast.makeText(requireActivity(), viewModel.weatherList.value?.get(0).toString(), Toast.LENGTH_LONG).show()
                viewModel.onDoneNavigation()
            }
        })
        viewModel.weatherList.observe(viewLifecycleOwner, {
            viewModel.onDoneLoading()
        })
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

}