package com.example.gem.firstapp.webservice.base

import android.content.Context
import com.example.gem.firstapp.webservice.WebserviceBuilder

class ErrorHandler {

    companion object {

    }

    private val DEFAULT_CODE = -1
    private var DEFAULT_MESSAGE = ""
    private val STATUS_TAG = "status"
    private val MESSAGE_TAG = "message"
    private val ERROR = "error"
    var OFFLINE_MSG = "offline"

    private var context: Context? = null

    private var sInstance: ErrorHandler? = null

    private var mCode = DEFAULT_CODE
    private var mMessage = DEFAULT_MESSAGE

    constructor() {
    }


}