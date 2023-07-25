package com.example.weather3.icons

import com.example.weather3.R


class IconMap {
    fun getIcon(code: String): Int {
        val iconMap= mapOf(
            "01d" to R.drawable.dbir,
            "02d" to R.drawable.diki,
            "03d" to R.drawable.duc,
            "04d" to R.drawable.ddort,
            "09d" to R.drawable.ddokuz,
            "10d" to R.drawable.don,
            "11d" to R.drawable.donbir,
            "13d" to R.drawable.donuc,
            "50d" to R.drawable.delli,
            "01n" to R.drawable.nbir,
            "02n" to R.drawable.niki,
            "03n" to R.drawable.nuc,
            "04n" to R.drawable.ndort,
            "09n" to R.drawable.ndokuz,
            "10n" to R.drawable.non,
            "11n" to R.drawable.nonbir,
            "13n" to R.drawable.nonuc,
            "50n" to R.drawable.nelli,
        )
        return iconMap[code]!!
    }
}