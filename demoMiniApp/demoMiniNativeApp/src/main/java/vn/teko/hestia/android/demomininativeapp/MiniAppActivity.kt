package vn.teko.hestia.android.demomininativeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import vn.teko.android.payment.kit.PaymentKit
import vn.teko.android.payment.kit.PaymentResultCallback
import vn.teko.android.payment.kit.model.PaymentRequest
import vn.teko.android.payment.kit.model.PaymentResult
import java.util.*


class MiniAppActivity : AppCompatActivity() {

    private var progressDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mini_app_activity_mini_app)

        title = "Mini Application"

        progressDialog = getProgressDialog()

        val extraIdToken = intent.getStringArrayExtra("extra_id_token")

        findViewById<Button>(R.id.btnRequestPayment).setOnClickListener {
            PaymentKit.pay(context = this,
                paymentRequest = PaymentRequest(
                    orderCode = "terra-6789",
                    amount = 10000,
                    merchantCode = "TRIPI"
                ),
                callback = object : PaymentResultCallback {
                    override fun onResult(result: PaymentResult) {
                        val paymentResultStatus = when (result.resultCode) {
                            PaymentResult.RESULT_CANCELED -> "canceled"
                            PaymentResult.RESULT_FAILED -> "failed"
                            PaymentResult.RESULT_SUCCEEDED -> "succeeded"
                            else -> "processed with unknown status"
                        }
                        val message = "Payment was $paymentResultStatus"

                        Toast.makeText(this@MiniAppActivity, message, Toast.LENGTH_LONG).show()
                    }
                }
            )
        }

        findViewById<Button>(R.id.btnPayWithQRCode).setOnClickListener {
            progressDialog?.show()
            PaymentKit.payWithQRCode(context = this,
                paymentRequest = PaymentRequest(
                    orderCode = "terra-6789",
                    amount = 10000,
                    merchantCode = "TRIPI"
                ),
                callback = object : PaymentResultCallback {
                    override fun onResult(result: PaymentResult) {
                        progressDialog?.dismiss()
                        val paymentResultStatus = when (result.resultCode) {
                            PaymentResult.RESULT_CANCELED -> "canceled"
                            PaymentResult.RESULT_FAILED -> "failed"
                            PaymentResult.RESULT_SUCCEEDED -> "succeeded"
                            else -> "processed with unknown status"
                        }
                        val message = "Payment was $paymentResultStatus"

                        Toast.makeText(this@MiniAppActivity, message, Toast.LENGTH_LONG).show()
                    }
                }
            )
        }

    }

    override fun onDestroy() {
        super.onDestroy()

        progressDialog?.dismiss()
    }

    private fun getProgressDialog(): AlertDialog {
        val builder = AlertDialog.Builder(this)
        val customLayout = layoutInflater.inflate(R.layout.mini_app_dialog_progress, null)
        builder.setView(customLayout)

        val dialog = builder.create()
        dialog.setCanceledOnTouchOutside(false)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent);

        return dialog
    }

}
