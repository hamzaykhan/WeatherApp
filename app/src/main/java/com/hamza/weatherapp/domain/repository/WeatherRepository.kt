package com.hamza.weatherapp.domain.repository

import com.hamza.weatherapp.domain.model.WeatherItem
import com.hamza.weatherapp.utils.wrapper.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
    fun getWeatherUpdate(showLoader: Boolean): Flow<Resource<WeatherItem>>
}