package vn.teko.android.payment.example_v2.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import vn.teko.android.core.util.Result
import vn.teko.terra.core.AuthInterface
import vn.teko.terra.core.hestia.MiniAppToken

class AuthInterfaceMock : AuthInterface, CoroutineScope by MainScope() {
    override fun exchangeMiniAppToken(
        iamAudience: String,
        result: (Result<MiniAppToken, Throwable>) -> Unit
    ): Job {
        return launch {
            result.invoke(Result.success(MiniAppToken()))
        }
    }

}