package com.mesutdurmuser.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mesutdurmuser.weatherapp.model.Weather
import com.mesutdurmuser.weatherapp.model.WeatherModel
import com.mesutdurmuser.weatherapp.repository.WeatherRepository
import com.mesutdurmuser.weatherapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository) : ViewModel(){



    private val _resp = MutableLiveData<WeatherModel>()
    val weatherResp:LiveData<WeatherModel>
        get() = _resp


    private val _getIcon = MutableLiveData<Weather>()
    val getIconUrl : LiveData<Weather>
        get() = _getIcon

    init {
        getWeather()
    }

    private fun getWeather()= viewModelScope.launch {
        repository.getWeather().let { response ->
            if (response.isSuccessful){
                _resp.postValue(response.body())
            }else{
                Log.d("Tag", "getWeather Error Response:  ${response.message()}")
                Resource.error("Error", null)
            }
        }

     /*   repository.getIcon().let { response ->
            if (response.isSuccessful){
                _getIcon.postValue(response.body())
            }else{
                Log.d("Tag", "getIcon Error Response:  ${response.message()}")
                Resource.error("Error", null)
            }
        }*/
    }


}