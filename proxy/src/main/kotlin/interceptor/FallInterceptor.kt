package interceptor

import net.sf.cglib.proxy.MethodInterceptor
import net.sf.cglib.proxy.MethodProxy
import java.lang.reflect.Method

class FallInterceptor: MethodInterceptor {
    override fun intercept(obj: Any?, method: Method?, args: Array<out Any>?, proxy: MethodProxy?): Any? {
        println("_________intercepted fall_________")
        return proxy?.invokeSuper(obj, args)
    }
}