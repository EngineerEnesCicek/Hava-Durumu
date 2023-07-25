package com.example.weather3.data.service

import WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HavaDurumuAPI {
    @GET("data/2.5/weather?")
    suspend fun getData(@Query("q")cityName:String,@Query("appid") api_key:String): Response<WeatherModel>
}