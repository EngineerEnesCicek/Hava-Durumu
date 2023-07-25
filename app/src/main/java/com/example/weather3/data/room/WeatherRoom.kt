package com.example.weather3.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="weather_room")
data class WeatherRoom(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo
    val id:Int=0,
    @ColumnInfo("temp")
    val temp: Double?,
    @ColumnInfo("feelsLike")
    var feelsLike:Double?,
    @ColumnInfo("humidity")
    val humidity: Int?,
    @ColumnInfo("pressure")
    val pressure: Int?,
    @ColumnInfo("temp_max")
    val tempMax: Double?,
    @ColumnInfo("temp_min")
    val tempMin: Double?,
    @ColumnInfo("lat")
    val lat: Double?,
    @ColumnInfo("lon")
    val lon: Double?,
    @ColumnInfo("description")
    val description: String?,
    @ColumnInfo("icon")
    val icon: String?,
    @ColumnInfo("country")
    val country: String?,
    @ColumnInfo("deg")
    val deg: Int?,
    @ColumnInfo("speed")
    val speed: Double?,
    @ColumnInfo("name")
    val name: String?
)