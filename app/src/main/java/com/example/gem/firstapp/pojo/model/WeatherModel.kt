package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.WeatherDTO

class WeatherModel : Parcelable {

    private var id: Int? = null
    private var main: String? = null
    private var description: String? = null
    private var icon: String? = null

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

    fun getId(): Int {
        return id!!
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getMain(): String {
        return main!!
    }

    fun setMain(main: String) {
        this.main = main
    }

    fun getDescription(): String {
        return description!!
    }

    fun setDescription(description: String) {
        this.description = description
    }

    fun getIcon(): String {
        return icon!!
    }

    fun setIcon(icon: String) {
        this.icon = icon
    }

}