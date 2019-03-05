package com.example.gem.firstapp.pojo.dto

import com.google.gson.annotations.SerializedName

class WindDTO {
    @SerializedName("speed")
    var speed: Double? = null

    @SerializedName("deg")
    var deg: Int? = null

    constructor() {}
}