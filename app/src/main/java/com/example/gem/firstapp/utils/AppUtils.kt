package com.example.gem.firstapp.utils

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Camera
import android.location.LocationManager
import android.os.Build
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.widget.Toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GooglePlayServicesUtil
import java.lang.Exception
import java.nio.file.PathMatcher
import java.text.SimpleDateFormat
import java.util.*

class AppUtils {

    private var mContext: Context? = null
    private var sdfFull: SimpleDateFormat = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")

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
                locationProviders =
                    Settings.Secure.getString(context.contentResolver, Settings.Secure.LOCATION_PROVIDERS_ALLOWED)
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
                // do nothing
            }
            try {
                network_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
            } catch (e: Exception) {
                // do nothing
            }
            return gps_enable || network_enabled
        }

        fun checkPlayServices(activity: Activity): Boolean {
            var resultCode: Int = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity)
            if (resultCode != ConnectionResult.SUCCESS) {
                if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                    GooglePlayServicesUtil.getErrorDialog(resultCode, activity, PLAY_SERVICES_RESOLUTION_REQUEST).show()
                } else {
                    Toast.makeText(activity, "This device is not supported by Google Play Service", Toast.LENGTH_SHORT)
                        .show()
                    activity.finish()
                }
                return false
            }
            return true
        }

        fun checkLastActivity(context: Context, className: String): Boolean {
            var mngr: ActivityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            var taskList: MutableList<ActivityManager.RunningTaskInfo> = mngr.getRunningTasks(10)
            if (taskList.get(0).numActivities == 1 &&
                taskList.get(0).topActivity.className.equals(className)
            ) {
                return true
            }
            return false
        }

        fun getOptimalPreviewSize(sizes: MutableList<Camera.Size>, w: Int, h: Int): Camera.Size {
            var minDiff: Double = Double.MAX_VALUE
            var surfaceRatio = w / h as Double
            // Cannot find the one match the aspect ratio, ignore the require
            var bestSize: Camera.Size?= null
            for (size: Camera.Size in sizes) {
                var diff: Double = Math.abs(size.width / size.height as Double - surfaceRatio)
                if (diff < minDiff) {
                    minDiff = diff
                    bestSize = size
                }
            }
            return bestSize!!
        }

        fun calculatorDistance(lat1: Double, lng1: Double, lat2: Double, lng2: Double): Double {
            val r: Int = 6371;  // Radius of the earth

            var latDistance: Double = Math.toRadians(lat2 - lat1)
            var lngDistance: Double = Math.toRadians(lng2 - lng1)
            var a: Double = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lngDistance / 2) * Math.sin(lngDistance / 2)
            var c: Double = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a))
            var distance: Double = r * c

            var heigth: Double = 0.0
            distance = Math.pow(distance, 2.0) + Math.pow(heigth, 2.0)
            return Math.sqrt(distance)
        }
    }

    fun init(context: Context) {
        this.mContext = context
    }

    fun checkPermission(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(mContext!!, permission) == PackageManager.PERMISSION_GRANTED
    }

    fun isFlashLightAvaiable(): Boolean {
        return mContext!!.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)
    }

    fun checkCameraFront(): Boolean {
        if (mContext!!.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT))
            return true
        return false
    }

    fun getCurrentTimeInString(): String {
        return sdfFull.format(Date())
    }

}