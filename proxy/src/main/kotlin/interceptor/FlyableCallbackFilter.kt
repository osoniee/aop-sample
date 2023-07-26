package interceptor

import net.sf.cglib.proxy.CallbackFilter
import java.lang.reflect.Method

class FlyableCallbackFilter: CallbackFilter {
    override fun accept(method: Method?): Int = when(method?.name) {
        "fly" -> 0
        "fall" -> 1
        else -> 2
    }
}