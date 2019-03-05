package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.WindDTO

class WindModel : Parcelable {
    private var speed: Double?
        get() {
            return speed
        }
        set(value) {
            this.speed = value
        }

    private var deg: Int?
        get() {
            return deg
        }
        set(value) {
            this.deg = value
        }

    protected constructor(parcel: Parcel) {
        this.speed = parcel.readDouble()
        this.deg = parcel.readInt()
    }

    constructor() {}

    fun convert(dto: WindDTO) {
        this.speed = dto.speed
        this.deg = dto.deg
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(speed!!)
        parcel.writeInt(deg!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WindModel> {
        override fun createFromParcel(parcel: Parcel): WindModel {
            return WindModel(parcel)
        }

        override fun newArray(size: Int): Array<WindModel?> {
            return arrayOfNulls(size)
        }
    }


}