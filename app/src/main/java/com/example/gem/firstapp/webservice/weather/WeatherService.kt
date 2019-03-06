package com.example.gem.firstapp.webservice.weather

import com.example.gem.firstapp.pojo.dto.LocationWeatherDTO
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("weather")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): Single<LocationWeatherDTO>

}