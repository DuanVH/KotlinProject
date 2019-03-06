package com.example.gem.firstapp.base.activity.vipe

import io.reactivex.disposables.Disposable
import org.xml.sax.ErrorHandler

abstract class BaseActivityInteractor<P> : BaseActivityContract.Interactor<P> {

    private var mPresenter: P? = null
    private var mBaseActivityDisposables: List<Disposable>? = null

    constructor(mPresenter: P?) {
        this.mPresenter = mPresenter
        mBaseActivityDisposables = mutableListOf()
    }

    override fun getPresenter(): P {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addDisposable(disposable: Disposable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dispose() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    protected fun handleError(throwable: Throwable, callback: ErrorHandler.ErrorHandlerCallback) {
//        val errorHandle = ErrorHandler.getInstance()
//        errorHandle.handleError(throwable, callback)
//    }

}