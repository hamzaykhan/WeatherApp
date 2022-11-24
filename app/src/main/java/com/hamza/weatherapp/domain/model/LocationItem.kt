package com.hamza.weatherapp.domain.model

data class LocationItem(
    val city: String,
    val country: String,
    val timeZone: String,
    val coordinates: CoordinatesItem
)
