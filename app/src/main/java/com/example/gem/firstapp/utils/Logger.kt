package com.example.gem.firstapp.utils

import java.lang.Exception

class Logger {

    companion object {
        fun logException(e: Exception) {
            // todo
            e.printStackTrace()
        }

        fun logException(throwable: Throwable) {
            // todo
            throwable.printStackTrace()
        }
    }
}