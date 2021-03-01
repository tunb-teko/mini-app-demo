package vn.teko.android.payment.example_v2.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import vn.teko.hestia.android.R.string
import vn.teko.hestia.android.utils.extensions.showMessageDialog
import vn.teko.hestia.android.utils.extensions.showProgressDialog
import vn.teko.hestia.core.HestiaUIHelper

class DefaultAndroidHestiaUIHelper(private val context: Context?) :
    HestiaUIHelper {

    private var progressDialog: AlertDialog? = null

    override fun showLoading() {
        progressDialog = context.showProgressDialog()
    }

    override fun hideLoading() {
        progressDialog?.dismiss()
    }

    override fun showError(message: String) {
        context?.run {
            showMessageDialog(
                title = getString(string.hestia_android_error),
                message = message,
                positiveButtonTitle = string.hestia_android_ok,
                positiveButtonAction = { _, _ -> },
                cancelable = true
            )
        }
    }

}