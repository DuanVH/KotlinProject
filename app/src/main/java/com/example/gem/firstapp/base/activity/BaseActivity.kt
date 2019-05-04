package com.example.gem.firstapp.base.activity.vipe

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.Toast
import butterknife.ButterKnife
import butterknife.Unbinder
import com.example.gem.firstapp.pojo.dto.BusEvent
import com.example.gem.firstapp.service.ConnectionHelper
import com.example.gem.firstapp.utils.DialogUtils
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.Exception

/*
 * Created by maboy on April 22, 2019
 */

abstract class BaseActivity<P : ActivityContract.Presenter<*, *>> : FragmentActivity(),
    ActivityContract.View<P>, DialogInterface.OnCancelListener {

    companion object {
        private var TAG: String = "BaseActivity: "
    }

    private var mPresenter: P? = null
    private var mUnbinder: Unbinder? = null
    private var mLoadingDialog: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        mUnbinder = ButterKnife.bind(this)

        mPresenter = initPresenter()
//        mPresenter?.attachView(this)  // TODO ???

        if (getFragmentContainerId() != 0)  /*getFirstFragment() != null is always true*/
            supportFragmentManager.beginTransaction()
                .add(getFragmentContainerId(), getFirstFragment()!!)
                .commit()

        mLoadingDialog = DialogUtils.createLoadingDialog(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus)
            window.decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
    }

    override fun onDestroy() {
        mUnbinder!!.unbind()
        getPresenter().dispose()
        super.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        notifyNetworkChanged()
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(busEvent: BusEvent) {
        if (busEvent.getType() == BusEvent.TYPE.CONNECTION_STATUS)
            notifyNetworkChanged()
    }

    protected abstract fun getLayoutResId(): Int

    protected abstract fun getFirstFragment(): Fragment?

    protected abstract fun getFragmentContainerId(): Int

    override fun getPresenter(): P {
        return mPresenter!!
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showMessage(stringResId: Int) {
        Toast.makeText(this, stringResId, Toast.LENGTH_SHORT).show()
    }

    override fun showLoadingDialog() {
        if (!mLoadingDialog!!.isShowing)
            mLoadingDialog!!.show()
    }

    override fun dismissLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog!!.isShowing)
            mLoadingDialog!!.dismiss()
    }

    override fun notifyNetworkChanged() {
        if (!ConnectionHelper.getInstance().isNotified()) {
            if (!ConnectionHelper.getInstance().isOnLine()) {
                // do nothing
            }
        }
    }

}