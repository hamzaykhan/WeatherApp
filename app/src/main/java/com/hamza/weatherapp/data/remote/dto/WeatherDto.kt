package com.hamza.weatherapp.data.remote.dto

data class WeatherDto(
    val consolidated_weather: List<ConsolidatedWeatherDto>,
    val latt_long: String,
    val location_type: String,
    val parent: ParentDto,
    val sources: List<SourceDto>,
    val sun_rise: String,
    val sun_set: String,
    val time: String,
    val timezone: String,
    val timezone_name: String,
    val title: String,
    val woeid: Int
)
