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

    fun putLongValue(key: String, n: Long) {
        mSharedPreferences!!.edit().putLong(key, n).apply()
    }

    fun getLongValue(key: String): Long {
        return mSharedPreferences!!.getLong(key, 0)
    }

    fun putIntValue(key: String, n: Int) {
        mSharedPreferences!!.edit().putInt(key, n).apply()
    }

    fun getIntValue(key: String): Int {
        return mSharedPreferences!!.getInt(key, 0)
    }

    fun putStringValue(key: String, s: String) {
        mSharedPreferences!!.edit().putString(key, s).apply()
    }

    fun putStringValue(key: String, s: String, sync: Boolean) {
        if (!sync)
            putStringValue(key, s)
        else
            mSharedPreferences!!.edit().putString(key, s).commit()
    }

    fun getStringValue(key: String): String {
        return mSharedPreferences!!.getString(key, "")
    }

    fun getStringValue(key: String, defaultValue: String): String {
        return mSharedPreferences!!.getString(key, defaultValue)
    }

    fun putBooleanValue(key: String, b: Boolean) {
        mSharedPreferences!!.edit().putBoolean(key, b).apply()
    }

    fun getBooleanValue(key: String): Boolean {
        return mSharedPreferences!!.getBoolean(key, false)
    }

    fun putFloatValue(key: String, f: Float) {
        mSharedPreferences!!.edit().putFloat(key, f).apply()
    }

    fun getFloatValue(key: String): Float {
        return mSharedPreferences!!.getFloat(key, 0.0f)
    }

}