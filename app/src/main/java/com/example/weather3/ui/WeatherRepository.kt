package com.example.weather3.ui

import WeatherModel
import com.example.weather3.data.service.Credentials
import com.example.weather3.data.service.Service
import kotlinx.coroutines.*


class WeatherRepository{
    fun getWeather(cityname:String,weatherModel:(WeatherModel?)->Unit){
        CoroutineScope(Dispatchers.IO).launch {
            val weatherApi=Service.service
            val response=weatherApi.getData(cityname,Credentials.API_KEY)
            if (response.isSuccessful){
                weatherModel(response.body())
            }
        }
    }
}