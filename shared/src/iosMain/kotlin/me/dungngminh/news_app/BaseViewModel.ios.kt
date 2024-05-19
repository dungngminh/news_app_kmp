package me.dungngminh.news_app

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

actual open class BaseViewModel {
    actual val scope: CoroutineScope
        get() = CoroutineScope(Dispatchers.Main.immediate)

    fun clear()  {
        scope.cancel()
    }
}
