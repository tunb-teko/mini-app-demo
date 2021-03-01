package vn.teko.hestia.android.demomininativeapp

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