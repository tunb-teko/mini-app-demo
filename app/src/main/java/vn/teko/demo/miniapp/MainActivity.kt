package vn.teko.demo.miniapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import vn.teko.android.payment.example_v2.utils.AuthInterfaceMock
import vn.teko.android.payment.example_v2.utils.DefaultAndroidHestiaUIHelper
import vn.teko.hestia.android.TerraHestia
import vn.teko.terra.core.AuthInterface
import vn.teko.terra.core.android.terra.TerraApp

class MainActivity : AppCompatActivity() {

    private val authMock: AuthInterface by lazy { AuthInterfaceMock() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}