package com.example.gem.firstapp.base.activity.vipe

import com.example.gem.firstapp.webservice.base.ErrorHandler
import io.reactivex.disposables.Disposable

abstract class BaseActivityInteractor<P : ActivityContract.Presenter<*, *>> : ActivityContract.Interactor<P> {

    private var mPresenter: P? = null
    private var mBaseActivityDisposables: MutableList<Disposable>? = null

    constructor(mPresenter: P?) {
        this.mPresenter = mPresenter
        mBaseActivityDisposables = mutableListOf()
    }

    override fun getPresenter(): P {
        return mPresenter!!
    }

    override fun addDisposable(disposable: Disposable) {
        mBaseActivityDisposables!!.add(disposable)
    }

    override fun dispose() {
        if (mBaseActivityDisposables != null && !mBaseActivityDisposables!!.isEmpty()) {
            for (dis : Disposable in mBaseActivityDisposables!!)
                if (!dis.isDisposed)
                    dis.dispose()
        }
    }

    protected fun handleError(throwable: Throwable, callback: ErrorHandler.ErrorHandlerCallback) {
        val errorHandle = ErrorHandler.getInstance()
        errorHandle.handlerError(throwable, callback)
    }

}