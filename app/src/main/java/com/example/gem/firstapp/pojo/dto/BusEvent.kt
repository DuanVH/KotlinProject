package com.example.gem.firstapp.pojo.dto

import java.util.*

class BusEvent {
    private var type: Int? = null
    private var content: Objects? = null

    constructor(type: Int?) {
        this.type = type
    }

    constructor(type: Int?, content: Objects?) {
        this.type = type
        this.content = content
    }

    fun setType(type: Int?) {
        this.type = type
    }

    fun getType(): Int {
        return type!!
    }

    fun setContent(content: Objects?) {
        this.content = content
    }

    fun getContent(): Objects {
        return content!!
    }

    object TYPE {
        val KEY_NUMBER_PRESSED = 1
        val CONNECTION_STATUS = 8
        val CONNECTION_ONLINE = 9
        val CONNECTION_OFFLINE = 10
        val LOCATION = 2
        val SPOT_MODEL = 3
        val DOWNLOAD_AR = 5
    }

}