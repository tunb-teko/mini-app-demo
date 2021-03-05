package vn.teko.hestia.android.demomininativeapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.teko.android.payment.kit.PaymentKit
import vn.teko.android.payment.kit.PaymentResultCallback
import vn.teko.android.payment.kit.model.PaymentRequest
import vn.teko.android.payment.kit.model.PaymentResult


class MiniAppActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mini_app)

        title = "Mini Application"

        val extraIdToken = intent.getStringArrayExtra("extra_id_token")

        findViewById<Button>(R.id.btnRequestPayment).setOnClickListener {
            PaymentKit.pay(context = this,
                paymentRequest = PaymentRequest(
                    orderCode = "terra-6789",
                    amount = 10000
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

    }

}
