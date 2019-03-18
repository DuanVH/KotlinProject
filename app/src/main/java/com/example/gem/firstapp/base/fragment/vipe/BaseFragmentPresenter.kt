package com.example.gem.firstapp.base.fragment.vipe

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragmentPresenter<V: FragmentContract.View<*>, I: FragmentContract.Interactor<*>> : FragmentContract.Presenter<V, I> {

    private var mView: V? = null
    private var mInteractor: I? = null

    constructor() {
        mView = initView()
        mInteractor = initInteractor()
        mView!!.setPresenter(this as Nothing)
    }

    override fun getView(): V {
        return mView!!
    }

    override fun getInteractor(): I {
        return mInteractor!!
    }

    override fun getFragment(): Fragment {
        return mView as Fragment
    }

    fun getFragment(bundle: Bundle): Fragment {
        (mView as Fragment).arguments = bundle
        return mView as Fragment
    }

    override fun getContext(): Context {
        return mView!!.getMvpContext()
    }

    override fun onError(errorMessageCode: String) {
        getView().dismissLoadingDialog()
        getView().showMessage(errorMessageCode)
    }

    override fun onError(errorMessageId: Int) {
        getView().dismissLoadingDialog()
        getView().showMessage(errorMessageId)
    }

    override fun dispose() {
        if (getInteractor() != null)
            getInteractor().dispose()
    }

}