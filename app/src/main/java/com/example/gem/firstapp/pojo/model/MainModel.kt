package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.MainDTO

class MainModel : Parcelable {
    private var temp: Double? = null
//        get() {
//            return temp
//        }
//        set(value) {
//            this.temp = value
//        }

    private var pressure: Long? = null
//        get() {
//            return pressure
//        }
//        set(value) {
//            this.pressure = pressure
//        }

    private var humidity: Int? = null
//        get() {
//            return humidity
//        }
//        set(value) {
//            this.humidity = value
//        }

    private var tempMin: Double? = null
//        get() {
//            return tempMin
//        }
//        set(value) {
//            this.tempMin = value
//        }

    private var tempMax: Double? = null
//        get() {
//            return tempMax
//        }
//        set(value) {
//            this.tempMax = value
//        }

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
}