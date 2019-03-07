package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.LocationWeatherDTO

class LocationWeatherModel : Parcelable {
    private var coord: CoordModel
    private var weathers: MutableList<WeatherModel>
    private var base: String? = null
    private var main: MainModel
    private var visibility: Long? = null
    private var wind: WindModel
    private var clouds: CloudsModel
    private var dt: Long? = null
    private var sys: SysModel
    private var id: Long? = null
    private var name: String? = null
    private var cod: Int? = null

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

        base = dto.base!!

        if (dto.main != null)
            main!!.convert(dto.main!!)

        visibility = dto.visibility!!

        if (dto.wind != null)
            wind!!.convert(dto.wind!!)

        if (dto.clouds != null)
            clouds!!.convert(dto.clouds!!)

        dt = dto.dt!!

        if (dto.sys != null)
            sys!!.convert(dto.sys!!)

        id = dto.id!!

        name = dto.name!!

        cod = dto.cod!!
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

    fun getCoord(): CoordModel {
        return coord
    }

    fun setCoord(coord: CoordModel) {
        this.coord = coord
    }

    fun getWeathers(): MutableList<WeatherModel> {
        return weathers
    }

    fun setWeathers(weathers: MutableList<WeatherModel>) {
        this.weathers = weathers
    }

    fun getBase(): String {
        return base!!
    }

    fun setBase(base: String) {
        this.base = base
    }

    fun getMain(): MainModel {
        return main
    }

    fun setMain(main: MainModel) {
        this.main = main
    }

    fun getVisibility(): Long {
        return visibility!!
    }

    fun setVisibility(visibility: Long) {
        this.visibility = visibility
    }

    fun getWind(): WindModel {
        return wind
    }

    fun setWind(wind: WindModel) {
        this.wind = wind
    }

    fun getClouds(): CloudsModel {
        return clouds
    }

    fun setClouds(clouds: CloudsModel) {
        this.clouds = clouds
    }

    fun getDt(): Long {
        return dt!!
    }

    fun setDt(dt: Long) {
        this.dt = dt
    }

    fun getSys(): SysModel {
        return sys
    }

    fun setSys(sys: SysModel) {
        this.sys = sys
    }

    fun getId(): Long {
        return id!!
    }

    fun setId(id: Long) {
        this.id = id
    }

    fun getName(): String {
        return name!!
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCod(): Int {
        return cod!!
    }

    fun setCod(cod: Int) {
        this.cod = cod
    }
}