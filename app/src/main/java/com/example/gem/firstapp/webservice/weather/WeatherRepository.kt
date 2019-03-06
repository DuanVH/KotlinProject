package com.example.gem.firstapp.webservice.weather

import com.example.gem.firstapp.pojo.dto.LocationWeatherDTO
import com.example.gem.firstapp.pojo.model.CoordModel
import com.example.gem.firstapp.pojo.model.LocationWeatherModel
import com.example.gem.firstapp.webservice.WebserviceBuilder
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.functions.Function

class WeatherRepository {

    companion object {
        fun fetchWeather(lat: Double, lon: Double, appid: String): Single<LocationWeatherModel> {
            return WebserviceBuilder.getInstance().getWeatherService()
                .getWeather(lat, lon, appid)
                .flatMap(Function<LocationWeatherDTO, SingleSource<LocationWeatherModel>>() {
                    dto ->
                    var model = LocationWeatherModel()
                    model.convert(dto)
                    Single.just(model)
                })
        }
    }
}