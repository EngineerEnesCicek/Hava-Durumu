package com.example.weather3.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
        val retrofitBuilder= Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
        val retrofit=retrofitBuilder.build()
        val service=retrofit.create(HavaDurumuAPI::class.java)
}