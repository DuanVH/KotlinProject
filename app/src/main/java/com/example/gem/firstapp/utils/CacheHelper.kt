package com.example.gem.firstapp.utils

import android.content.Context
import android.content.SharedPreferences

class CacheHelper {

    private var mContext: Context? = null
    private var mSharedPreferences: SharedPreferences? = null
    companion object {
        private val PREF_NAME = "com.maboy.kotlin"

        private var sInstance: CacheHelper? = null

        fun getInstance(): CacheHelper {
            if (sInstance == null) {
                synchronized(CacheHelper::class.java) {
                    if (sInstance == null)
                        sInstance = CacheHelper()
                }
            }
            return sInstance!!
        }
    }

    fun init(context: Context) {
        this.mContext = context
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }
}