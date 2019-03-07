package com.example.gem.firstapp.webservice.base

import android.content.Context
import com.example.gem.firstapp.webservice.WebserviceBuilder

class ErrorHandler {

    companion object {
        private val DEFAULT_CODE = -1
        private var DEFAULT_MESSAGE = ""
        private val STATUS_TAG = "status"
        private val MESSAGE_TAG = "message"
        private val ERROR = "error"
        var OFFLINE_MSG = "offline"
        private var sInstance: ErrorHandler? = null

        fun getInstance(): ErrorHandler {
            if (sInstance == null)
                synchronized(ErrorHandler::class.java) {
                    sInstance = ErrorHandler()
                }
            return sInstance!!
        }
    }
    private var context: Context? = null
    private var mCode = DEFAULT_CODE
    private var mMessage = DEFAULT_MESSAGE

    constructor() {
    }

    fun init(context: Context) {
        this.context = context
        DEFAULT_MESSAGE = "An error has just occurred. Please try again later."
        OFFLINE_MSG = "You are offline. Please check your internet connection!"
    }

    fun getCode(): Int {
        return mCode
    }

    fun getMessage(): String {
        return mMessage
    }

    fun handlerError(throwable: Throwable, callBacl: ErrorHandlerCallback) {
        mCode = -1
        // TODO
    }


    interface ErrorHandlerCallback {
        fun onNetworKFailed()

        fun onErrorResponse(error: String)
    }

}