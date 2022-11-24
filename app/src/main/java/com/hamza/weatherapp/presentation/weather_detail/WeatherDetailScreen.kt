package com.hamza.weatherapp.presentation.weather_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hamza.weatherapp.BuildConfig
import kotlin.math.abs
import kotlin.math.round

@Composable
fun WeatherDetailScreen(
    state: WeatherDetailState
) {
    state.weatherDetail?.let { weatherItem ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = weatherItem.location.city,
                fontSize = 30.sp,
                modifier = Modifier.align(Alignment.Start),
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(28.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                AsyncImage(
                    model = BuildConfig.IMAGE_URL.replace("{weather_state_abbr}", weatherItem.stateAbbr),
                    placeholder = painterResource(id = state.defaultIcon),
                    contentDescription = weatherItem.stateName,
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "${abs(weatherItem.currentTemp).toInt()}°",
                    fontSize = 50.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(
                text = weatherItem.stateName,
                fontSize = 16.sp,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "L:${abs(weatherItem.minTemp).toInt()}° H:${abs(weatherItem.maxTemp).toInt()}°",
                fontSize = 24.sp,
                color = Color.Black
            )
        }
    }
}