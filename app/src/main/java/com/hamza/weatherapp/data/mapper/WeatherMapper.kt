package com.hamza.weatherapp.data.mapper

import com.hamza.weatherapp.data.remote.dto.WeatherDto
import com.hamza.weatherapp.domain.model.LocationItem
import com.hamza.weatherapp.domain.model.WeatherItem
import com.hamza.weatherapp.utils.Utils

fun WeatherDto.toWeatherItem(): WeatherItem {
    val consolidatedWeather = this.consolidated_weather.random()
    return WeatherItem(
        location = LocationItem(
            city = this.title,
            country = this.parent.title,
            timeZone = this.timezone,
            coordinates = Utils.stringToCoordinates(this.latt_long)
        ),
        stateName = consolidatedWeather.weather_state_name,
        stateAbbr = consolidatedWeather.weather_state_abbr,
        maxTemp = consolidatedWeather.max_temp,
        minTemp = consolidatedWeather.min_temp,
        currentTemp = consolidatedWeather.the_temp,
        createdDate = Utils.stringToLocalDateTime(consolidatedWeather.created),
        applicableDate = Utils.stringToLocalDate(consolidatedWeather.applicable_date),
    )
}