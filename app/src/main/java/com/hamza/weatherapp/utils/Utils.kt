package com.hamza.weatherapp.utils

import com.hamza.weatherapp.domain.model.CoordinatesItem
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object Utils {

    private const val dateTimePattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSX"
    private const val datePattern = "yyyy-MM-dd"

    fun stringToCoordinates(value: String): CoordinatesItem {
        val coordinates = value.split(",")
        return CoordinatesItem(
            latitude = coordinates[0].toDouble(),
            longitude = coordinates[1].toDouble()
        )
    }

    fun stringToLocalDateTime(dateTime: String): LocalDateTime {
        val formatter = DateTimeFormatter.ofPattern(dateTimePattern, Locale.getDefault())
        return LocalDateTime.parse(dateTime, formatter)
    }

    fun stringToLocalDate(date: String): LocalDate {
        val formatter = DateTimeFormatter.ofPattern(datePattern, Locale.getDefault())
        return LocalDate.parse(date, formatter)
    }
}