package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.MainDTO

class MainModel : Parcelable {
    private var temp: Double? = null
    private var pressure: Long? = null
    private var humidity: Int? = null
    private var tempMin: Double? = null
    private var tempMax: Double? = null

    protected constructor(parcel: Parcel) {
        this.temp = parcel.readDouble()
        this.pressure = parcel.readLong()
        this.humidity = parcel.readInt()
        this.tempMin = parcel.readDouble()
        this.tempMax = parcel.readDouble()
    }

    constructor() {}

    fun convert(dto: MainDTO) {
        this.temp = dto.temp
        this.pressure = dto.pressure
        this.humidity = dto.humidity
        this.tempMin = dto.tempMin
        this.tempMax = dto.tempMax
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(temp!!)
        parcel.writeLong(pressure!!)
        parcel.writeInt(humidity!!)
        parcel.writeDouble(tempMin!!)
        parcel.writeDouble(tempMax!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainModel> {
        override fun createFromParcel(parcel: Parcel): MainModel {
            return MainModel(parcel)
        }

        override fun newArray(size: Int): Array<MainModel?> {
            return arrayOfNulls(size)
        }
    }

    fun getTemp(): Double {
        return temp!!
    }

    fun setTemp(temp: Double) {
        this.temp = temp
    }

    fun getPressure(): Long {
        return pressure!!
    }

    fun setPressure(pressure: Long) {
        this.pressure = pressure
    }

    fun getTempMin(): Double {
        return tempMin!!
    }

    fun getHumidity(): Int {
        return humidity!!
    }

    fun setHumidity(humidity: Int) {
        this.humidity = humidity
    }

    fun setTempMin(tempMin: Double) {
        this.tempMin = tempMin
    }

    fun getTempMax(): Double {
        return tempMax!!
    }

    fun setTempMax(tempMax: Double) {
        this.tempMax = tempMax
    }
}