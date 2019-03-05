package com.example.gem.firstapp.pojo.dto

import com.google.gson.annotations.SerializedName

class MainDTO {
    @SerializedName("temp")
    var temp: Double? = null

    @SerializedName("pressure")
    var pressure: Long? = null

    @SerializedName("humidity")
    var humidity: Int? = null

    @SerializedName("temp_min")
    var tempMin: Double? = null

    @SerializedName("temp_max")
    var tempMax: Double? = null

    constructor() {}
}