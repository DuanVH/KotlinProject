package com.example.gem.firstapp.ui.home

import com.example.gem.firstapp.base.activity.vipe.BaseActivityPresenter

class MainPresenter : BaseActivityPresenter<MainContract.View, MainContract.Interactor>(), MainContract.Presenter {

    override fun initInteractor(): MainContract.Interactor {
        return MainInteractor(this)
    }

    override fun getData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getSuccess() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getFailure() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
