package vn.teko.demo.miniapp

import android.app.Application
import vn.teko.android.payment.example_v2.utils.EnvForTesting
import vn.teko.android.payment.manager.TerraPayment
import vn.teko.android.payment.ui.PaymentUISdk
import vn.teko.terra.core.android.terra.TerraApp

class ExampleApp : Application() {

    override fun onCreate() {
        val terraApp = TerraApp.initializeApp(this)
        super.onCreate()
        EnvForTesting.initEnv()
        PaymentUISdk.getInstance(this, terraApp)
        TerraPayment.getInstance(this, terraApp).apply {
            config.userId = "Fixed UserId"
        }
    }
}