package com.hamza.weatherapp.data.remote.dto

data class SourceDto(
    val crawl_rate: Int,
    val slug: String,
    val title: String,
    val url: String
)
