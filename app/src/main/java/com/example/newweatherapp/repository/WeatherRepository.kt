package com.example.newweatherapp.repository


import com.example.newweatherapp.model.WeatherData
import com.example.newweatherapp.network.RetrofitAdapter
import com.example.newweatherapp.util.Constants
import com.example.newweatherapp.util.apiToData

class WeatherRepository {
    private val weatherService = RetrofitAdapter.getInstance()

    suspend fun getCurrentWeatherForecast(): List<WeatherData> {
        val call = weatherService.getForecastListDataByLonLat(
            Constants.LATITUDE,
            Constants.LONGITUDE,
            Constants.EXCLUDE,
            Constants.API_KEY
        )
        return apiToData(call)
    }
}