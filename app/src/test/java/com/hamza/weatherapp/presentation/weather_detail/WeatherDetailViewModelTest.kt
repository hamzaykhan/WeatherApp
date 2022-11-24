package com.hamza.weatherapp.presentation.weather_detail

import com.google.common.truth.Truth.assertThat
import com.hamza.weatherapp.domain.repository.FakeWeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class WeatherDetailViewModelTest {

    private lateinit var viewModel: WeatherDetailViewModel
    private lateinit var fakeRepository: FakeWeatherRepository

    @Before
    fun setUp() {
        Dispatchers.setMain(Dispatchers.Unconfined)
        fakeRepository = FakeWeatherRepository()
        viewModel = WeatherDetailViewModel(fakeRepository)
    }

    @Test
    fun getWeatherUpdate_ReceivedData_SuccessState() {
        viewModel.getWeatherUpdate()

        assertThat(viewModel.state.weatherDetail).isNotNull()
    }

    @Test
    fun should_throwException_when_NetworkError() {
        fakeRepository.setShouldReturnNetworkError(true)
        viewModel.getWeatherUpdate()

        assertThat(viewModel.state.error).isNotNull()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}