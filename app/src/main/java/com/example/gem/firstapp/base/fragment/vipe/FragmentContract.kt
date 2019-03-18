package com.example.gem.firstapp.base.fragment.vipe

import android.content.Context
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import io.reactivex.disposables.Disposable

interface FragmentContract {
    interface Interactor<P> {
        fun getPresenter(): P

        fun addDisposable(disposable: Disposable)

        fun dispose()
    }

    interface Presenter<V, I> {
        fun initView(): V?

        fun initInteractor(): I

        fun getView(): V

        fun getInteractor(): I

        fun getFragment(): Fragment

        fun getContext(): Context

        fun onError(errorMessageCode: String)

        fun onError(errorMessageId: Int)

        fun dispose()
    }

    interface View<P> {
        fun getPresenter(): P

        fun setPresenter(presenter: P)

        fun getMvpContext(): Context

        fun showLoadingDialog()

        fun dismissLoadingDialog()

        fun showMessage(message: String)

        fun showMessage(@StringRes messageResId: Int)
    }
}