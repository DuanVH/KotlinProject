package com.example.gem.firstapp.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import java.lang.Exception
import java.nio.file.PathMatcher
import java.text.SimpleDateFormat

class AppUtils {

    companion object {
        private var PLAY_SERVICES_RESOLUTION_REQUEST = 1000
        var mInstance: AppUtils? = null

        fun getInstance(): AppUtils {
            if (mInstance == null) mInstance = AppUtils()
            return mInstance!!
        }

        fun isLocationEnabled(context: Context): Boolean {
            var locationMode: Int = 0;
            var locationProviders: String? = null

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                try {
                    locationMode = Settings.Secure.getInt(context.contentResolver, Settings.Secure.LOCATION_MODE);
                } catch (e: Settings.SettingNotFoundException) {
                    e.printStackTrace()
                    return false
                }
                return locationMode != Settings.Secure.LOCATION_MODE_OFF
            } else {
                locationProviders = Settings.Secure.getString(context.contentResolver, Settings.Secure.LOCATION_PROVIDERS_ALLOWED)
                return !TextUtils.isEmpty(locationProviders)
            }
        }

        fun isLocationServiceEnabled(context: Context): Boolean {
            var locationManager: LocationManager? = null
            var gps_enable: Boolean = false
            var network_enabled: Boolean = false

            if (locationManager == null)
                locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            try {
                network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            } catch (e: Exception) {

            }
            return gps_enable || network_enabled
        }

        fun checkPlayServices(activity: Activity): Boolean {
//            var resultCode: Int = GooglePla
            return false
        }
    }
    private var mContext: Context? = null
    private var sdfFull: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")

    fun init(context: Context) {
        this.mContext = context
    }

    fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(mContext!!, permission) == PackageManager.PERMISSION_GRANTED
    }


}