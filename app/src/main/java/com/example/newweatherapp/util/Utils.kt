package com.example.newweatherapp.util

import com.example.newweatherapp.api.Base
import com.example.newweatherapp.model.WeatherData

fun apiToData(base: Base?): List<WeatherData> {
    val data = ArrayList<WeatherData>()

    base?.apply {
        for (hourly in base.hourly) {
            data.add(WeatherData(hourly.temp, hourly.weather[0].icon))
        }
    }
    return data
}