package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.LocationWeatherDTO
import com.example.gem.firstapp.pojo.dto.WeatherDTO

class LocationWeatherModel : Parcelable {
    private var coord: CoordModel?
        get() {
            return coord
        }
        set(value) {
            this.coord = value
        }

    private var weathers: MutableList<WeatherModel>?
        get() {
            return weathers
        }
        set(value) {
            this.weathers = value
        }

    private var base: String?
        get() {
            return base
        }
        set(value) {
            this.base = value
        }

    private var main: MainModel?
        get() {
            return main
        }
        set(value) {
            this.main = value
        }

    private var visibility: Long?
        get() {
            return visibility
        }
        set(value) {
            this.visibility = value
        }

    private var wind: WindModel?
        get() {
            return wind
        }
        set(value) {
            this.wind = value
        }

    private var clouds: CloudsModel?
        get() {
            return clouds
        }
        set(value) {
            this.clouds = value
        }

    private var dt: Long?
        get() {
            return dt
        }
        set(value) {
            this.dt = value
        }

    private var sys: SysModel?
        get() {
            return sys
        }
        set(value) {
            this.sys = value
        }

    private var id: Long?
        get() {
            return id
        }
        set(value) {
            this.id = id
        }

    private var name: String?
        get() {
            return name
        }
        set(value) {
            this.name = value
        }

    private var cod: Int?
        get() {
            return cod
        }
        set(value) {
            this.cod = value
        }

    protected constructor(parcel: Parcel) {
        coord = parcel.readParcelable(CoordModel.javaClass.classLoader)
        weathers = parcel.createTypedArrayList(WeatherModel.CREATOR)
        base = parcel.readString()
        main = parcel.readParcelable(MainModel.javaClass.classLoader)
        visibility = parcel.readLong()
        wind = parcel.readParcelable(WindModel.javaClass.classLoader)
        clouds = parcel.readParcelable(CloudsModel.javaClass.classLoader)
        dt = parcel.readLong()
        sys = parcel.readParcelable(SysModel.javaClass.classLoader)
        id = parcel.readLong()
        name = parcel.readString()
        cod = parcel.readInt()
    }

    constructor() {
        coord = CoordModel()
        weathers = mutableListOf()
        main = MainModel()
        wind = WindModel()
        clouds = CloudsModel()
        sys = SysModel()
    }

    fun convert(dto: LocationWeatherDTO) {
        if (dto.coord != null)
            coord!!.convert(dto.coord!!)

        if (dto.weathers != null && !dto.weathers!!.isEmpty())
            for (item in dto.weathers!!) {
                var w: WeatherModel = WeatherModel()
                w.convert(item)
                weathers!!.add(w)
            }

        base = dto.base

        if (dto.main != null)
            main!!.convert(dto.main!!)

        visibility = dto.visibility

        if (dto.wind != null)
            wind!!.convert(dto.wind!!)

        if (dto.clouds != null)
            clouds!!.convert(dto.clouds!!)

        dt = dto.dt

        if (dto.sys != null)
            sys!!.convert(dto.sys!!)

        id = dto.id

        name = dto.name

        cod = dto.cod
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(coord, flags)
        parcel.writeTypedList(weathers)
        parcel.writeString(base)
        parcel.writeParcelable(main, flags)
        parcel.writeLong(visibility!!)
        parcel.writeParcelable(wind, flags)
        parcel.writeParcelable(clouds, flags)
        parcel.writeLong(dt!!)
        parcel.writeParcelable(sys, flags)
        parcel.writeLong(id!!)
        parcel.writeString(name)
        parcel.writeInt(cod!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LocationWeatherModel> {
        override fun createFromParcel(parcel: Parcel): LocationWeatherModel {
            return LocationWeatherModel(parcel)
        }

        override fun newArray(size: Int): Array<LocationWeatherModel?> {
            return arrayOfNulls(size)
        }
    }
}