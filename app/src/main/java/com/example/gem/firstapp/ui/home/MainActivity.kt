package com.example.gem.firstapp.ui.home

import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.example.gem.firstapp.R
import com.example.gem.firstapp.base.activity.vipe.BaseActivity
import com.example.gem.firstapp.pojo.model.LocationWeatherModel
import com.example.gem.firstapp.webservice.WebserviceBuilder
import com.example.gem.firstapp.webservice.weather.WeatherRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : BaseActivity<MainContract.Presenter>(), MainContract.View {

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun getFirstFragment(): Fragment? {
        return null
    }

    override fun getFragmentContainerId(): Int {
        return 0
    }

    override fun onCancel(dialog: DialogInterface?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initPresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    override fun show() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
