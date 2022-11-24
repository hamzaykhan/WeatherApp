package com.hamza.weatherapp.data.remote

import com.hamza.weatherapp.data.remote.dto.WeatherDto
import retrofit2.http.GET

interface WeatherApi {
    @GET("4418.json")
    suspend fun getWeatherUpdate(): WeatherDto
}