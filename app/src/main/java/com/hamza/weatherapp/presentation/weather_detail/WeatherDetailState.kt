package com.hamza.weatherapp.presentation.weather_detail

import androidx.annotation.DrawableRes
import com.hamza.weatherapp.R
import com.hamza.weatherapp.domain.model.WeatherItem

data class WeatherDetailState(
    val weatherDetail: WeatherItem? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    @DrawableRes val defaultIcon: Int = R.drawable.ic_rainy
)
