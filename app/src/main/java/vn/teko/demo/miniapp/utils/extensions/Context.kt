package vn.teko.demo.miniapp.utils.extensions

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import vn.teko.hestia.android.R

internal fun Context?.showProgressDialog(): AlertDialog? {
    return if (this != null) {
        AlertDialog.Builder(this, R.style.HestiaAndroidProgressBarStyle)
            .setCancelable(false)
            .setView(R.layout.layout_hestia_android_dialog_progress)
            .show()
    } else null
}

internal fun Context?.showMessageDialog(
    title: String,
    message: String,
    positiveButtonTitle: Int,
    positiveButtonAction: (DialogInterface, Int) -> Unit,
    cancelable: Boolean = true
): AlertDialog? {
    return if (this != null) {
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveButtonTitle, positiveButtonAction)
            .setCancelable(cancelable)
            .show()
    } else null
}