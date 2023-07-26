package interceptor

import net.sf.cglib.proxy.MethodInterceptor
import net.sf.cglib.proxy.MethodProxy
import java.lang.reflect.Method

class CGLibMethodInterceptor: MethodInterceptor {
    override fun intercept(obj: Any?, method: Method?, args: Array<out Any>?, proxy: MethodProxy?): Any? = when(method?.name) {
            "fly" -> {
                println("_________catched fly_________")
                val result = proxy?.invokeSuper(obj, args)
                println("_________invoked fly_________")
                result
            }

            "fall" -> {
                println("_________catched fall_________")
                val result = proxy?.invokeSuper(obj, args)
                println("_________invoked fall_________")
                result
            }

            else -> proxy?.invokeSuper(obj, args)

    }
}