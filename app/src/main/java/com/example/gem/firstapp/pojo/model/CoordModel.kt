package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.CoordDTO

class CoordModel : Parcelable {

    private var lon: Double? = null
    private var lat: Double? = null

    constructor() {}

    protected constructor(parcel: Parcel) {
        this.lon = parcel.readDouble()
        this.lat = parcel.readDouble()
    }

    fun convert(dto: CoordDTO) {
        lon = dto.lon
        lat = dto.lat
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lon!!)
        parcel.writeDouble(lat!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoordModel> {
        override fun createFromParcel(parcel: Parcel): CoordModel {
            return CoordModel(parcel)
        }

        override fun newArray(size: Int): Array<CoordModel?> {
            return arrayOfNulls(size)
        }
    }

    fun getLat(): Double {
        return lat!!
    }

    fun getLon(): Double {
        return lon!!
    }
}