package vn.teko.hestia.android.demomininativeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import vn.teko.android.payment.kit.model.PaymentResult

class PaymentResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_result)

        val paymentResultStatus = when (intent.getIntExtra(PAYMENT_RESULT_CODE, 0)) {
            PaymentResult.RESULT_CANCELED -> "canceled"
            PaymentResult.RESULT_FAILED -> "failed"
            PaymentResult.RESULT_SUCCEEDED -> "succeeded"
            else -> "processed with unknown status"
        }

        title = "Payment was $paymentResultStatus"
    }

    companion object {
        private const val PAYMENT_RESULT_CODE = "PAYMENT_RESULT_CODE"

        internal fun start(context: Context, paymentResult: PaymentResult) {
            val intent = Intent(context, PaymentResultActivity::class.java).apply {
                putExtra(PAYMENT_RESULT_CODE, paymentResult.resultCode)
            }
            context.startActivity(intent)
        }
    }
}