package com.example.gem.firstapp.base.fragment.vipe

import com.example.gem.firstapp.webservice.base.ErrorHandler
import io.reactivex.disposables.Disposable
import java.util.logging.Logger

abstract class BaseFragmentInteractor<P: FragmentContract.Presenter<*, *>> : FragmentContract.Interactor<P> {

    private var mPresnter: P? = null
    private var baseFragmentDisposable: MutableList<Disposable>? = null

    constructor(presenter: P) {
        mPresnter = presenter
        baseFragmentDisposable = mutableListOf()
    }

    override fun getPresenter(): P {
        return mPresnter!!
    }

    override fun addDisposable(disposable: Disposable) {
        baseFragmentDisposable!!.add(disposable)
    }

    override fun dispose() {
        if (baseFragmentDisposable != null && !baseFragmentDisposable!!.isEmpty()) {
            for (disposable : Disposable in baseFragmentDisposable!!) {
                if (!disposable.isDisposed)
                    disposable.dispose()
            }
            baseFragmentDisposable!!.clear()
        }
    }

    protected fun handleError(throwable: Throwable, callback: ErrorHandler.ErrorHandlerCallback) {
        var errorHandler: ErrorHandler = ErrorHandler.getInstance()
        errorHandler.handlerError(throwable, callback)
    }
}