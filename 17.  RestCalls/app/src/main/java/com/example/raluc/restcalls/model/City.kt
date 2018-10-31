package com.example.raluc.restcalls.model

data class City (
    val id: Int,
    val name: String,
    val coord: Coord,
    val country: String,
    val population: Int
)