package com.example.gem.firstapp.pojo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.gem.firstapp.pojo.dto.CloudsDTO

class CloudsModel : Parcelable {
    private var all: Int?
        get() {
            return all
        }
        set(value) {
            this.all = value
        }

    protected constructor(parcel: Parcel) {
        this.all = parcel.readInt()
    }

    constructor() {}

    fun convert(dto: CloudsDTO) {
        this.all = dto.all
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(all!!)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CloudsModel> {
        override fun createFromParcel(parcel: Parcel): CloudsModel {
            return CloudsModel(parcel)
        }

        override fun newArray(size: Int): Array<CloudsModel?> {
            return arrayOfNulls(size)
        }
    }
}