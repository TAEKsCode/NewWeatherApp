package com.example.newweatherapp.ui.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.newweatherapp.databinding.WeatherFragmentBinding
import com.example.newweatherapp.model.WeatherViewModel
import com.example.newweatherapp.ui.recycler_stuff.RecyclerItemAdapter

class WeatherFragment : Fragment() {

    private val viewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = WeatherFragmentBinding.inflate(inflater, container, false)

        binding.weatherList.adapter = viewModel.weatherList.value?.let { RecyclerItemAdapter(it) }
        return binding.root
    }
}