package com.example.gem.firstapp.base

import android.support.multidex.MultiDexApplication
import com.example.gem.firstapp.utils.CacheHelper
import com.example.gem.firstapp.webservice.WebserviceBuilder

class KotlinProjectApplication : MultiDexApplication() {

    companion object {
        private lateinit var sInstance: KotlinProjectApplication

        fun getInstance(): KotlinProjectApplication {
            return sInstance
        }
    }

    override fun onCreate() {
        super.onCreate()
        sInstance = this
        CacheHelper.getInstance().init(this)
        WebserviceBuilder.getInstance().initServices()

        // TODO
    }

}