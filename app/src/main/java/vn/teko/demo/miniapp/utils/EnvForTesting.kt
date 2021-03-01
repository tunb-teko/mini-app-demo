package vn.teko.android.payment.example_v2.utils

import vn.teko.android.payment.v2.configuration.PaymentGatewayConfig

object EnvForTesting {

    private val baseUrlStg = "https://payment-setting.stag.tekoapis.net/"
    private val baseUrlDev = "https://payment-setting.dev.tekoapis.net/"
    private val baseUrlTest1 = "https://payment-setting.test-1.tekoapis.net/"


    private val secretKeyStg = "e377000f744bef4357f1b0badd07e595"
    private val secretKeyDev = "c7ae7d881a122457601d51a7e52d8ab2"
    private val secretKeyRegisterDev = "6eb20e96deb357a587ee59bfeb596fcc"
    private val secretKeyRegisterStg = "4eb7a9e909c6be62c9ba73fa79c2be85"


    const val DEV_ENV = "dev-default"
    const val STAG_ENV = "stag-default"
    const val STAG_SPOS_ENV = "stag-spos-default"
    const val DEV_SPOS_ENV = "dev-spos-default"


    val environment = HashMap<String, PaymentGatewayConfig>()

    fun initEnv() {
        val paymentGatewayStg = PaymentGatewayConfig(
            terminalCode = "M001_TID001",
            clientCode = "M001",
            serviceCode = "RETAIL",
            secretKey = secretKeyStg,
            baseUrl = baseUrlStg,
            logging = true,
            registerSecretKey = secretKeyRegisterStg,
            userId = "3d5a55406fe445f188f84ca5e480f0a9",
            successUrl = "https://payment-stg.teko.vn/",
            cancelUrl = "https://payment-stg.teko.vn/",
            mmc = "7011"
        )

        val paymentGatewayDev = PaymentGatewayConfig(
            terminalCode = "M001_TID001",
            clientCode = "M001",
            serviceCode = "RETAIL",
            secretKey = secretKeyDev,
            baseUrl = baseUrlDev,
            logging = true,
            registerSecretKey = secretKeyRegisterDev,
            userId = "3d5a55406fe445f188f84ca5e480f0a9",
            successUrl = "https://payment-stg.teko.vn/",
            cancelUrl = "https://payment-stg.teko.vn/",
            mmc = "7011"
        )

        val paymentConfigStagForSPOS = PaymentGatewayConfig(
            terminalCode = "PE1118CC50322", // will update the same with serial number
            clientCode = "PV-V2",
            serviceCode = "RETAIL",
            secretKey = "8d6cb033ff084be5a9aded9f803c4d6b",
            baseUrl = baseUrlStg,
            logging = true,
            registerSecretKey = secretKeyRegisterStg,
            userId = "3d5a55406fe445f188f84ca5e480f0a9",
            successUrl = "https://payment-stg.teko.vn/",
            cancelUrl = "https://payment-stg.teko.vn/",
            mmc = "4814"
        )


        val paymentConfigDevForSPOS = PaymentGatewayConfig(
            terminalCode = "", // will update the same with serial number
            clientCode = "PV-V2",
            serviceCode = "RETAIL",
            secretKey = "ba05cfbb5a7da4a3ee9b7eb94b79d2de",
            baseUrl = baseUrlDev,
            logging = true,
            registerSecretKey = secretKeyRegisterDev,
            userId = "3d5a55406fe445f188f84ca5e480f0a9",
            successUrl = "https://payment-stg.teko.vn/",
            cancelUrl = "https://payment-stg.teko.vn/",
            mmc = "4814"
        )

        environment[DEV_ENV] = paymentGatewayDev
        environment[STAG_ENV] = paymentGatewayStg
        environment[STAG_SPOS_ENV] = paymentConfigStagForSPOS
        environment[DEV_SPOS_ENV] = paymentConfigDevForSPOS
    }


}