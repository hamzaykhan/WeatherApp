package com.hamza.weatherapp.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

data class WeatherItem(
    val location: LocationItem,
    val stateName: String,
    val stateAbbr: String,
    val maxTemp: Double,
    val minTemp: Double,
    val currentTemp: Double,
    val createdDate: LocalDateTime,
    val applicableDate: LocalDate
)
