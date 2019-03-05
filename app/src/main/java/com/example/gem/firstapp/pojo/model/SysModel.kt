package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.SysDTO

class SysModel : Parcelable {
    private var type: Int?
        get() {
            return type
        }
        set(value) {
            this.type = value
        }

    private var id: Long?
        get() {
            return id
        }
        set(value) {
            this.id = value
        }

    private var message: Double?
        get() {
            return message
        }
        set(value) {
            this.message = value
        }

    private var country: String?
        get() {
            return country
        }
        set(value) {
            this.country = value
        }

    private var sunrise: Long?
        get() {
            return sunrise
        }
        set(value) {
            this.sunrise = value
        }

    private var sunset: Long?
        get() {
            return sunset
        }
        set(value) {
            this.sunset = value
        }

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
}