package com.mesutdurmuser.weatherapp.repository

import com.mesutdurmuser.weatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val apiService: ApiService){

    suspend fun getWeather() = apiService.getWeather()
}