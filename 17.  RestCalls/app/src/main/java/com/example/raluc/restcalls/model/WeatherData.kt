package com.example.raluc.restcalls.model

data class WeatherData(
    val cod: String, val message: Double, val cnt: Int, val list: List <WeatherList>, val city: City)