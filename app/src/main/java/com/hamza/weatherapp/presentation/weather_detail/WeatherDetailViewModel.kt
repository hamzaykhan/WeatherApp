package com.hamza.weatherapp.presentation.weather_detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamza.weatherapp.domain.repository.WeatherRepository
import com.hamza.weatherapp.utils.wrapper.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherDetailViewModel @Inject constructor(
    private val repository: WeatherRepository
): ViewModel() {
    var state by mutableStateOf(WeatherDetailState())
        private set

    init {
        getWeatherUpdate(showLoader = true)
    }

    fun getWeatherUpdate(showLoader: Boolean = false, dispatcher: CoroutineDispatcher = Dispatchers.Main) {
        viewModelScope.launch(dispatcher) {
            repository.getWeatherUpdate(showLoader).collect { resource ->
                when (resource) {
                    is Resource.Loading -> state = state.copy(
                        isLoading = true,
                        error = null
                    )
                    is Resource.Error -> state = state.copy(
                        error = resource.exception.message,
                        weatherDetail = null,
                        isLoading = false
                    )
                    is Resource.Success -> state = state.copy(
                        isLoading = false,
                        weatherDetail = resource?.data,
                        error = null
                    )
                }
            }
        }
    }
}