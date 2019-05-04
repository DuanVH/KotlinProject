package com.example.gem.firstapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class NetworkUtils {
    companion object {
        fun checkNetwork(context: Context?): NetworkType {

            if (context == null) return NetworkType.DISCONNECT

            val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            val activeNetInfo = manager.activeNetworkInfo
            return if (activeNetInfo == null || !activeNetInfo.isAvailable) {
                NetworkType.DISCONNECT
            } else {
                //      if (com.alticast.viettelottcommons.WindmillConfiguration.NETWORK_FAKE) {
                //        return com.alticast.viettelottcommons.WindmillConfiguration.is3gMode ? NetworkType.MOBILE : NetworkType.WIFI;
                //      }
                if (activeNetInfo.type == ConnectivityManager.TYPE_MOBILE) {
                    NetworkType.MOBILE
                } else {
                    NetworkType.WIFI
                }
            }
        }

        enum class NetworkType {
            DISCONNECT,
            WIFI,
            MOBILE
        }
    }

}