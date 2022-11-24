package com.hamza.weatherapp.data.remote.dto

data class ParentDto(
    val latt_long: String,
    val location_type: String,
    val title: String,
    val woeid: Int
)
