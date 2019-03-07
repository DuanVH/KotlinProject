package com.example.gem.firstapp.base.activity.vipe

import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseActivity<P : ActivityContract.Presenter<*, *>> : FragmentActivity, ActivityContract.View<P> {

    companion object {
        private var TAG: String = "BaseActivity: "
    }

    private var mPresenter: P? = null
    private var mUnbinder: Unbinder? = null
    private var mLoadingDialog: Dialog? = null

    constructor() : super()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        mUnbinder = ButterKnife.bind(this)

        mPresenter = initPresenter()
        mPresenter?.attachView(this as Nothing)

        if (getFragmentContainerId() != 0 && getFirstFragment() != null)  /*getFirstFragment() != null is always true*/
            supportFragmentManager.beginTransaction()
                .add(getFragmentContainerId(), getFirstFragment())
                .commit()

//        mLoadingDialog = Di
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    protected abstract fun getLayoutResId(): Int

    protected abstract fun getFirstFragment(): Fragment

    protected abstract fun getFragmentContainerId(): Int

    override fun getPresenter(): P {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initPresenter(): P {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(stringResId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoadingDialog() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun notifyNetworkChanged() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}