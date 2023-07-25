package com.example.weather3.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeatherRoom::class], version = 1, exportSchema = false)
abstract class WeatherDatabase :RoomDatabase(){
    abstract fun weatherDao(): WeatherDAO
    companion object{
        @Volatile
        private var instance: WeatherDatabase?=null
        fun getWeatherDatabase(context:Context): WeatherDatabase?{
            if (instance ==null){
                instance = Room.databaseBuilder(
                    context,
                    WeatherDatabase::class.java,
                    "weatherRoom.db"
                ).allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}