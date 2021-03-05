package vn.teko.hestia.android.demomininativeapp

/**
 * The class that contains initialize data from the Super app.
 * This is used for providing the Super app's data inside the Mini app
 *
 * @property dummyString
 * @constructor Create empty Mini app sdk
 */
class MiniAppSdk(
    private val dummyString: String
) {

    fun getDummyString(): String = dummyString

    companion object {
        private lateinit var instance: MiniAppSdk

        fun initialize(dummyString: String) {
            instance =
                MiniAppSdk(dummyString)
        }

        fun getInstance(): MiniAppSdk {
            if (this::instance.isInitialized) {
                return instance
            } else {
                throw Exception("Need initialize sdk first")
            }
        }
    }
}