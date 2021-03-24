package com.example.newweatherapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newweatherapp.repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val weatherRepository = WeatherRepository()

    //when true, show splash screen
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val weatherList = MutableLiveData<List<WeatherData>>()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            weatherList.value = weatherRepository.getCurrentWeatherForecast()
        }
    }

    fun onDoneNavigation(){
        _isLoading.value = false
    }

    fun onDoneLoading(){
        _isLoading.value = true
    }
}