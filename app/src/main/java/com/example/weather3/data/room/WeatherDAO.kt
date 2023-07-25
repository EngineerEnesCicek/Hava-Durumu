package com.example.weather3.data.room

import WeatherModel
import androidx.room.*
import com.example.weather3.data.room.WeatherRoom

@Dao
interface WeatherDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(weatherRoom: WeatherRoom)
    @Update
    fun update(weatherRoom: WeatherRoom)
    @Query("SELECT*FROM weather_room")
    fun getDataFromDb(): WeatherRoom
}