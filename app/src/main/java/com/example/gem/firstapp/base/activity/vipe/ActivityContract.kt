package com.example.gem.firstapp.base.activity.vipe

import android.content.Context
import android.support.annotation.StringRes
import io.reactivex.disposables.Disposable

interface ActivityContract {

    interface Interactor<P> {

        fun getPresenter(): P

        fun addDisposable(disposable: Disposable)

        fun dispose()
    }

    interface View<P> {

        fun getPresenter(): P

        fun initPresenter(): P

        fun showMessage(message: String)

        fun showMessage(@StringRes stringResId: Int)

        fun showLoadingDialog()

        fun dismissLoadingDialog()

        fun notifyNetworkChanged()
    }

    interface Presenter<V, I> {
        fun getView(): V

        fun getInteractor(): I

        fun getContext(): Context

        fun initInteractor(): I

        fun attachView(view: V)

        fun dispose()

        fun onError(errorCode: Int, errorMessageCode: String)
    }
}