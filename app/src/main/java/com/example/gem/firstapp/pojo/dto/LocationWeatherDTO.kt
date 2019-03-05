package com.example.gem.firstapp.pojo.dto

import com.google.gson.annotations.SerializedName

class LocationWeatherDTO {
    @SerializedName("coord")
    var coord: CoordDTO? = null

    @SerializedName("weather")
    var weather: WeatherDTO? = null

    @SerializedName("base")
    var base: String? = null

    @SerializedName("main")
    var main: MainDTO? = null

    @SerializedName("visibility")
    var visibility: Long? = null

    @SerializedName("wind")
    var wind: WindDTO? = null

    @SerializedName("clouds")
    var clouds: CloudsDTO? = null

    @SerializedName("dt")
    var dt: Long? = null

    @SerializedName("sys")
    var sys: SysDTO? = null

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("cod")
    var cod: Int? = null

    constructor() {}
}