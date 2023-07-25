package com.example.weather3.ui.view

import WeatherModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.weather3.data.room.WeatherDatabase
import com.example.weather3.data.room.WeatherRoom
import com.example.weather3.ui.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    var weatherLiveData = MutableLiveData<WeatherRoom>()
    private var weatherRepository = WeatherRepository()
    private val weatherDatabase = WeatherDatabase.getWeatherDatabase(application)
    fun getLastWeather(cityname: String) {

        weatherRepository.getWeather(cityname) { data ->
            CoroutineScope(Dispatchers.IO).launch {
                setData(data!!)
            }
        }
    }

    private suspend fun setData(weatherModel: WeatherModel) {
        val weatherRoom = WeatherRoom(
            0,
            weatherModel.main.temp,
            weatherModel.main.feelsLike,
            weatherModel.main.humidity,
            weatherModel.main.pressure,
            weatherModel.main.tempMax,
            weatherModel.main.tempMin,
            weatherModel.coord.lat,
            weatherModel.coord.lon,
            weatherModel.weather[0].description,
            weatherModel.weather[0].icon,
            weatherModel.sys.country,
            weatherModel.wind.deg,
            weatherModel.wind.speed,
            weatherModel.name
        )
        weatherDatabase?.weatherDao()?.getDataFromDb()?.let {
            weatherDatabase.weatherDao().update(weatherRoom)
        }
            ?: weatherDatabase?.weatherDao()?.insert(weatherRoom)
        getData()
    }

    fun getData() {
        weatherLiveData.postValue(weatherDatabase?.weatherDao()?.getDataFromDb())
    }
}