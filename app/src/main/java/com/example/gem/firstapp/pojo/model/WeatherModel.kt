package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.WeatherDTO

class WeatherModel : Parcelable {

    private var id: Int?
        get() {
            return id
        }
        set(value) {
            this.id = value
        }

    private var main: String?
        get() {
            return main
        }
        set(value) {
            this.main = value
        }

    private var description: String?
        get() {
            return description
        }
        set(value) {
            this.description = value
        }

    private var icon: String?
        get() {
            return icon
        }
        set(value) {
            this.icon = value
        }

    protected constructor(parcel: Parcel) {
        this.id = parcel.readInt()
        this.main = parcel.readString()
        this.description = parcel.readString()
        this.icon = parcel.readString()
    }

    constructor() {}

    fun convert(dto: WeatherDTO) {
        id = dto.id
        main = dto.main
        description = dto.description
        icon = dto.icon
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id!!)
        parcel.writeString(main)
        parcel.writeString(description)
        parcel.writeString(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherModel> {
        override fun createFromParcel(parcel: Parcel): WeatherModel {
            return WeatherModel(parcel)
        }

        override fun newArray(size: Int): Array<WeatherModel?> {
            return arrayOfNulls(size)
        }
    }

}