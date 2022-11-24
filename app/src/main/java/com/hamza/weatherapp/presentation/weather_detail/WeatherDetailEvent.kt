package com.hamza.weatherapp.presentation.weather_detail

sealed class WeatherDetailEvent {
    object Refresh: WeatherDetailEvent()
}
