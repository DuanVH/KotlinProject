package com.example.gem.firstapp.pojo.model

import android.os.Message
import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.SysDTO

class SysModel : Parcelable {
    private var type: Int? = null
    private var id: Long? = null
    private var message: Double? = null
    private var country: String? = null
    private var sunrise: Long? = null
    private var sunset: Long? = null

    constructor(parcel: Parcel) {
        this.type = parcel.readInt()
        this.id = parcel.readLong()
        this.message = parcel.readDouble()
        this.country = parcel.readString()
        this.sunrise = parcel.readLong()
        this.sunset = parcel.readLong()
    }

    constructor() {}

    fun convert(dto: SysDTO) {
        this.type = dto.type
        this.id = dto.id
        this.message = dto.message
        this.country = dto.country
        this.sunrise = dto.sunrise
        this.sunset = dto.sunset
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(type!!)
        parcel.writeLong(id!!)
        parcel.writeDouble(message!!)
        parcel.writeString(country)
        parcel.writeLong(sunrise!!)
        parcel.writeLong(sunset!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SysModel> {
        override fun createFromParcel(parcel: Parcel): SysModel {
            return SysModel(parcel)
        }

        override fun newArray(size: Int): Array<SysModel?> {
            return arrayOfNulls(size)
        }
    }

    fun getType(): Int {
        return type!!
    }

    fun setType(type: Int) {
        this.type = type
    }

    fun getId(): Long {
        return id!!
    }

    fun getMessage(): Double {
        return message!!
    }

    fun setMessage(message: Double) {
        this.message = message
    }

    fun getCountry(): String {
        return country!!
    }

    fun setCountry(country: String) {
        this.country = country
    }

    fun getSunrise(): Long {
        return sunrise!!
    }

    fun setSunrise(sunrise: Long) {
        this.sunrise = sunrise
    }

    fun getSunset(): Long {
        return sunset!!
    }

    fun setSunset(sunset: Long) {
        this.sunset = sunset
    }
}