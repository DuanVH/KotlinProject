package com.example.gem.firstapp.webservice.base

import android.content.Context
import android.os.Build
import android.system.ErrnoException
import com.example.gem.firstapp.utils.Logger
import com.example.gem.firstapp.utils.NetworkUtils
import com.example.gem.firstapp.webservice.WebserviceBuilder
import retrofit2.HttpException
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

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

    fun handlerError(throwable: Throwable, callback: ErrorHandlerCallback) {
        mCode = -1
        if (NetworkUtils.checkNetwork(context) == NetworkUtils.Companion.NetworkType.DISCONNECT) {
            mMessage = "You are offline"
            if (callback != null) callback.onNetworkFailed()
        } else {
            if (throwable is SocketTimeoutException ||
                throwable is ConnectException ||
                throwable is UnknownHostException || Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && throwable is ErrnoException
            ) run {
                mMessage = OFFLINE_MSG
                if (callback != null) callback.onNetworkFailed()
            } else {
                if (throwable is HttpException) {
                    var httpException: HttpException = throwable as HttpException
                    try {

                    } catch (e: IOException) {
                        Logger.logException(e)
                        mMessage = DEFAULT_MESSAGE
                    } finally {
                        if (callback != null) callback.onErrorResponse(mMessage)
                    }
                } else {
                    mMessage = throwable.message!!
                }
                if (callback != null) callback.onErrorResponse(mMessage)
            }
        }
    }

    interface ErrorHandlerCallback {
        fun onNetworkFailed()

        fun onErrorResponse(error: String)
    }

}