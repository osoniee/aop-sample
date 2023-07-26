package proxy

import net.sf.cglib.proxy.InvocationHandler
import java.lang.reflect.Method

class CGLibInvocationHandler(private val target: Any): InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        println("__________before invoke___________")
        return when (method?.name) {
            "fly" -> {
                println("__________invoke fly___________")
                return method.invoke(target, *args.orEmpty())
            }

            "fall" -> {
                println("__________invoke fall___________")
                return method.invoke(target, *args.orEmpty())
            }

            else -> method?.invoke(target, *args.orEmpty())
        }
    }
}