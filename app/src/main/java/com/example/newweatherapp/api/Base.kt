package com.example.newweatherapp.api

import com.google.gson.annotations.SerializedName

data class Base (

	@SerializedName("lat") val lat : Int,
	@SerializedName("lon") val lon : Int,
	@SerializedName("timezone") val timezone : String,
	@SerializedName("timezone_offset") val timezone_offset : Int,
	@SerializedName("hourly") val hourly : List<Hourly>
)