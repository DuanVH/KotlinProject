package com.example.gem.firstapp.service

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionHelper {

    private var lastNoConnectionTs: Long? = -1
    private var isOnLine: Boolean? = true
    private var networkChangeNotified: Boolean? = true

    companion object {
        private var instance: ConnectionHelper? = null

        fun getInstance(): ConnectionHelper {
            if (instance == null)
                instance = ConnectionHelper()
            return instance!!
        }

        fun isConnected(context: Context): Boolean {
            var cm: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetwork: NetworkInfo = cm.activeNetworkInfo

            return activeNetwork != null && activeNetwork.isConnected
        }

        fun isConenctedOrConnecting(context: Context): Boolean {
            var cm: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var activeNetWork: NetworkInfo = cm.activeNetworkInfo
            return activeNetWork != null && activeNetWork.isConnectedOrConnecting
        }
    }

    fun isNotified(): Boolean {
        var notified: Boolean = networkChangeNotified!!
        if (!networkChangeNotified!!) networkChangeNotified = true
        return notified
    }

    fun getLastNoConnectionTs(): Long {
        return lastNoConnectionTs!!
    }

    fun setLastNoConnectionTs(lastNoConnectionTs: Long) {
        this.lastNoConnectionTs = lastNoConnectionTs
    }

    fun isOnLine():Boolean {
        return isOnLine!!
    }

    fun setOnLine(online: Boolean) {
        this.isOnLine = online
    }

    fun isNetworkChangeNotified(): Boolean {
        return networkChangeNotified!!
    }

    fun setNetworkChangeNotified(networkChangeNotified: Boolean) {
        this.networkChangeNotified = networkChangeNotified
    }
}