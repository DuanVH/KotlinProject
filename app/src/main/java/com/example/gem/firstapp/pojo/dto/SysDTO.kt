package com.example.gem.firstapp.pojo.dto

import com.google.gson.annotations.SerializedName

class SysDTO {
    @SerializedName("type")
    var type: Int? = null

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("message")
    var message: Double? = null

    @SerializedName("country")
    var country: String? = null

    @SerializedName("sunrise")
    var sunrise: Long? = null

    @SerializedName("sunset")
    var sunset: Long? = null

    constructor() {}
}