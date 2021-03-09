package vn.teko.demo.miniapp

import android.app.Application
import vn.teko.android.payment.ui.PaymentUISdk
import vn.teko.terra.core.android.terra.TerraApp

class ExampleApp : Application() {

    override fun onCreate() {
        val terraApp = TerraApp.initializeApp(this)
        super.onCreate()
        PaymentUISdk.getInstance(this, terraApp)
    }
}