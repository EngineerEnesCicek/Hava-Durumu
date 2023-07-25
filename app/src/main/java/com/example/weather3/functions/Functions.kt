package com.example.weather3.functions

import java.text.DecimalFormat

object Functions {
    val df= DecimalFormat("#.##")
    fun celciusCalculator(number:Double):String{
        return df.format(number-273.15)
    }
    fun fahrenheitCalculator(number:Double):String{
        return df.format((number-273.15)*1.8+32)
    }
}