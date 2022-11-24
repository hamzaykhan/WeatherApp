package com.hamza.weatherapp.data.repository

import com.hamza.weatherapp.data.mapper.toWeatherItem
import com.hamza.weatherapp.data.remote.WeatherApi
import com.hamza.weatherapp.domain.model.WeatherItem
import com.hamza.weatherapp.domain.repository.WeatherRepository
import com.hamza.weatherapp.utils.wrapper.Resource
import com.hamza.weatherapp.utils.wrapper.callApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepository {
    override fun getWeatherUpdate(showLoader: Boolean): Flow<Resource<WeatherItem>>  = flow {
        if (showLoader) emit(Resource.Loading)

        val result = callApi {
            api.getWeatherUpdate().toWeatherItem()
        }

        emit(result)
    }
}