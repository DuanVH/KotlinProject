package com.example.gem.firstapp.base.activity.vipe

import android.content.Context

abstract class BaseActivityPresenter<V : ActivityContract.View<*>, I : ActivityContract.Interactor<*>>
    : ActivityContract.Presenter<V, I> {

    private var mView: V? = null
    private var mInteractor: I? = null

    constructor() {
        mInteractor = initInteractor()
    }


    override fun getView(): V {
        return mView!!
    }

    override fun getInteractor(): I {
        return mInteractor!!
    }

    override fun getContext(): Context {
        return mView as Context
    }

    override fun attachView(view: V) {
        mView = view
    }

    override fun dispose() {
        getInteractor().dispose()
    }

    override fun onError(errorCode: Int, errorMessageCode: String) {
        getView().dismissLoadingDialog()
    }
}