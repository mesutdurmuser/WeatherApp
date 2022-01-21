package com.mesutdurmuser.weatherapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mesutdurmuser.weatherapp.databinding.ActivityMainBinding
import com.mesutdurmuser.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.weatherResp.observe(this, {weather->
            binding.apply {
                binding.tvTemperature.text = weather.main.temp.toInt().toString()
                binding.tvCityName.text = weather.name
                binding.tvHumidity.text = "%${weather.main.humidity}"
                binding.tvSunrise.text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(weather.sys.sunrise.toLong()*1000))
                binding.tvSunset.text = SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(Date(weather.sys.sunset.toLong()*1000))
                binding.tvWind.text = "${weather.wind.speed} km"
                binding.tvUpdatedAt.text = weather.timezone.toString()
                binding.tvTempMin.text = "En düşük ${weather.main.tempMin}°C"
                binding.tvTempMax.text = "En yüksek ${weather.main.tempMax}°C"
                binding.tvPressure.text = weather.main.pressure.toString()
                binding.tvStatus.text = weather.weather[0].description
            }
        })

       /* viewModel.getIconUrl.observe(this,  {ıcon->
            binding.apply {
                binding.imgSearchCity.
            }
        })*/


    }
}