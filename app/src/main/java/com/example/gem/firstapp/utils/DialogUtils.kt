package com.example.gem.firstapp.utils

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import com.example.gem.firstapp.R

class DialogUtils {

    companion object {
        private var sDialog: Dialog? = null

        @Synchronized
        fun showLoadingDialog(context: Context) {
            if (sDialog == null) {
                sDialog = Dialog(context)
                sDialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
                sDialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                sDialog!!.setContentView(R.layout.dialog_loading)
                sDialog!!.setCancelable(true)
            }

            if (!sDialog!!.isShowing) {
                sDialog!!.show()
            }
        }

        @Synchronized
        fun showLoadingDialog(context: Context, onCancelListener: DialogInterface.OnCancelListener) {
            if (sDialog == null) {
                sDialog = Dialog(context)
                sDialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
                sDialog!!.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                sDialog!!.setContentView(R.layout.dialog_loading)
                sDialog!!.setCancelable(true)
                sDialog!!.setOnCancelListener(onCancelListener)
            }
            if (!sDialog!!.isShowing)
                sDialog!!.show()
        }

        fun createLoadingDialog(context: Context): Dialog {
            var dialog = Dialog(context)
            dialog.window.requestFeature(Window.FEATURE_NO_TITLE)
            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.setContentView(R.layout.dialog_loading)
            dialog.setCancelable(true)
            return dialog
        }

        @Synchronized
        fun dismissLoadingDialog() {
            if (sDialog != null && sDialog!!.isShowing) {
                sDialog!!.dismiss()
                sDialog = null
            }
        }

        fun createWarningDialog(context: Context, message: String,
                                onButtonOkClicked: DialogInterface.OnClickListener,
                                onButtonCancelClicked: DialogInterface.OnClickListener): Dialog {
            return AlertDialog.Builder(context)
                .setMessage(message)
                .setPositiveButton("Ok", onButtonOkClicked)
                .setNegativeButton("Cancel", onButtonCancelClicked)
                .create()
        }

//        fun
    }
}