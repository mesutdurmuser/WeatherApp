package com.mesutdurmuser.weatherapp.api

import com.mesutdurmuser.weatherapp.model.Weather
import com.mesutdurmuser.weatherapp.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/data/2.5/weather?&units=metric&q=Kocaeli&APPID=e9525a97dbd8d4a0b009c804dc337212")
    suspend fun getWeather(
        @Query("q") cityName: String
    ):Response<WeatherModel>

    @GET("/img/wn/10d@2x.png")
    suspend fun getIcon():Response<Weather>
}