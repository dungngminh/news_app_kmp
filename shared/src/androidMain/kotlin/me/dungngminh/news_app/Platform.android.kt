package me.dungngminh.news_app

import android.content.res.Resources
import android.os.Build
import kotlin.math.round
import kotlin.math.roundToInt

actual class Platform {
    actual val osName: String
        get() = "Android"
    actual val osVersion: String
        get() = "${Build.VERSION.SDK_INT}"
    actual val deviceModel: String
        get() = "${Build.MANUFACTURER} {${Build.MODEL}}"
    actual val density: Int
        get() = Resources.getSystem().displayMetrics.density.roundToInt()

    actual fun logSystemInfo() {
        println("osName: $osName \n osVersion: $osVersion \n deviceModel: $deviceModel \n density: $density")
    }
}