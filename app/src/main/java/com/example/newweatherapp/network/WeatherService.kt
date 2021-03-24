package com.example.newweatherapp.network

import com.example.newweatherapp.api.Base
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("/data/2.5/onecall?units=metric")
    suspend fun getForecastListDataByLonLat(
        @Query("lat") lattilude: Double,
        @Query("lon") longitude: Double,
        @Query("exclude") exclude: String,
        @Query("appid") app_id: String
    ): Base
}