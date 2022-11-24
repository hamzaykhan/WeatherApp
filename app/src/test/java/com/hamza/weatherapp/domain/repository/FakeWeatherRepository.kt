package com.hamza.weatherapp.domain.repository

import com.hamza.weatherapp.domain.model.LocationItem
import com.hamza.weatherapp.domain.model.WeatherItem
import com.hamza.weatherapp.utils.Utils
import com.hamza.weatherapp.utils.wrapper.FakeException
import com.hamza.weatherapp.utils.wrapper.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate
import java.time.LocalDateTime

class FakeWeatherRepository: WeatherRepository {

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value: Boolean) {
        this.shouldReturnNetworkError = value
    }

    override fun getWeatherUpdate(showLoader: Boolean): Flow<Resource<WeatherItem>>  = flow {
        if (shouldReturnNetworkError) {
            emit(Resource.Error(FakeException()))
        } else {
            emit(Resource.Success(
                WeatherItem(
                    location = LocationItem(
                        city = "",
                        country = "",
                        timeZone = "",
                        coordinates = Utils.stringToCoordinates("-1.0,-1.0")
                    ),
                    stateName = "",
                    stateAbbr = "",
                    maxTemp = 24.4,
                    minTemp = 24.4,
                    currentTemp = 24.4,
                    createdDate = LocalDateTime.now(),
                    applicableDate = LocalDate.now()
                )
            ))
        }
    }
}