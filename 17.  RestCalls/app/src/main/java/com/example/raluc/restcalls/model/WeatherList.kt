package com.example.raluc.restcalls.model

import com.google.gson.annotations.SerializedName

data class WeatherList (
    val dt: Int,
    val main: Main,
    val weather: List<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val rain: Rain,
    val sys: Sys,
    @SerializedName("dt_text")
    val dtText: String
)