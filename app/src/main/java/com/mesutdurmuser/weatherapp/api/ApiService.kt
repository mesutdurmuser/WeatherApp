package com.mesutdurmuser.weatherapp.api

import com.mesutdurmuser.weatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/data/2.5/weather?q=Bursa&APPID=e9525a97dbd8d4a0b009c804dc337212")
    suspend fun getWeather():Response<WeatherModel>
}