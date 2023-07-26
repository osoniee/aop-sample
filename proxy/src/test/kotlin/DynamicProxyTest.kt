import fly.Flyable
import fly.IronMan
import org.junit.jupiter.api.Test
import proxy.DynamicProxyHandler
import java.lang.reflect.Proxy

class DynamicProxyTest {
    @Test
    fun dynamicProxyTest() {
        val ironMan = Proxy.newProxyInstance(
            Flyable::class.java.classLoader,
            arrayOf(Flyable::class.java) as Array<Class<*>>,
            DynamicProxyHandler(IronMan())
        ) as Flyable
        ironMan.fly()
        ironMan.fall()
    }
}