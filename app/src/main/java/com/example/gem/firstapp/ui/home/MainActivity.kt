package com.example.gem.firstapp.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.gem.firstapp.R
import com.example.gem.firstapp.pojo.model.LocationWeatherModel
import com.example.gem.firstapp.webservice.WebserviceBuilder
import com.example.gem.firstapp.webservice.weather.WeatherRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        WebserviceBuilder.getInstance().initServices()

        WeatherRepository.fetchWeather(21.016864, 105.781938, "95d8bcfb1fad9da2047aaf1c22928d58")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<LocationWeatherModel> {
                override fun onSuccess(t: LocationWeatherModel) {
                    Log.e("DUAN_LOG", t.getCoord().toString())
                }

                override fun onSubscribe(d: Disposable) {
                    // TODO
                }

                override fun onError(e: Throwable) {
                    Log.e("DUAN_LOG", e.message)
                }

            })
    }
}
