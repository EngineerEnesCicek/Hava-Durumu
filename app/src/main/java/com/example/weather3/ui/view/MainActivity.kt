package com.example.weather3.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.weather3.data.room.WeatherRoom
import com.example.weather3.functions.Functions
import com.example.weather3.icons.IconMap
import com.example.weather3.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    var cityname=""
    val iconMap= IconMap()
    private lateinit var weatherDataOutput: WeatherRoom
    var isNotEmpty=false
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel= ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getData()
        showData()
        binding.imageView.setOnClickListener{
            cityname=binding.editText.text.toString()
            binding.editText.hint="CityName"
            binding.editText.text.clear()
            viewModel.getLastWeather(cityname)
        }
    }
    private fun showData() {
        viewModel.weatherLiveData.observe(this) {
            it?.let {
                setMain(it)
            }
            }
    }
    @SuppressLint("SetTextI18n")
    private fun setMain(weatherRoom: WeatherRoom) {
        weatherDataOutput=weatherRoom
        isNotEmpty=true
        with(binding){
            weatherRoom.icon?.let { iconMap.getIcon(it) }
                ?.let { havaDurumuIcon.setImageResource(it) }
            dereceText.text= "${weatherRoom.temp} K°"
            feelTempText.text="${weatherRoom.feelsLike} K°"
            minTempText.text="${weatherRoom.tempMin} K°"
            maxTempText.text="${weatherRoom.tempMax} K°"
            cityText.text= weatherRoom.name
            countryText.text= weatherRoom.country
            enlemDegerText.text= Functions.df.format(weatherRoom.lat)
            boylamDegerText.text= Functions.df.format(weatherRoom.lon)
            descriptionText.text= weatherRoom.description
            windSpeedText.text="${weatherRoom.speed} m/s"
            windImage.rotation=weatherRoom.deg!!.toFloat()
            pressureValueText.text=weatherRoom.pressure.toString()
            hummidityValueText.text=weatherRoom.humidity.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun celcius(view: View){
        if(isNotEmpty){
            binding.dereceText.text= "${Functions.celciusCalculator(weatherDataOutput.temp!!)} C°"
            binding.feelTempText.text="${Functions.celciusCalculator(weatherDataOutput.feelsLike!!)} C°"
            binding.maxTempText.text="${Functions.celciusCalculator(weatherDataOutput.tempMax!!)} C°"
            binding.minTempText.text="${Functions.celciusCalculator(weatherDataOutput.tempMin!!)} C°"
        }
    }
    @SuppressLint("SetTextI18n")
    fun fahrenheit(view: View){
        if(isNotEmpty){
            binding.dereceText.text= "${Functions.fahrenheitCalculator(weatherDataOutput.temp!!)} F°"
            binding.feelTempText.text="${Functions.fahrenheitCalculator(weatherDataOutput.feelsLike!!)} F°"
            binding.maxTempText.text="${Functions.fahrenheitCalculator(weatherDataOutput.tempMax!!)} F°"
            binding.minTempText.text="${Functions.fahrenheitCalculator(weatherDataOutput.tempMin!!)} F°"
        }
    }
}