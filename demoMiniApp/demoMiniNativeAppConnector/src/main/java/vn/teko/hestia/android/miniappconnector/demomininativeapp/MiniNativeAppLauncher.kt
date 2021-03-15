package vn.teko.hestia.android.miniappconnector.demomininativeapp

import android.app.Application
import android.content.Intent
import vn.teko.hestia.android.AndroidAppLauncher
import vn.teko.hestia.android.demomininativeapp.MiniAppSdk
import vn.teko.hestia.android.model.AppLauncherData

class MiniNativeAppLauncher : AndroidAppLauncher {

    override fun initApp(application: Application, launcherData: AppLauncherData) {
        val displayString =
            "${launcherData.extraConfig["dummyString"]}.${launcherData.extraConfig["dummyInt"]}"

        MiniAppSdk.initialize(displayString)
    }

    override fun initIntent(
        application: Application,
        intent: Intent,
        launcherData: AppLauncherData
    ) {
        println("launcherData.idToken: " + launcherData.idToken)
        intent.putExtra("extra_id_token", launcherData.idToken)
    }
}