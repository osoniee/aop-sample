import fly.IronMan
import interceptor.CGLibMethodInterceptor
import interceptor.FallInterceptor
import interceptor.FlyInterceptor
import interceptor.FlyableCallbackFilter
import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.NoOp
import org.junit.jupiter.api.Test


class MethodInterceptorTest {
    @Test
    fun interceptorTest() {
        val ironManEnhancer = Enhancer()
        ironManEnhancer.setSuperclass(IronMan::class.java)
        ironManEnhancer.setCallback(CGLibMethodInterceptor())
        val ironMan = ironManEnhancer.create() as IronMan

        println("fly")
        ironMan.fly()
        println("fall")
        ironMan.fall()
    }

    @Test
    fun interceptorWithFilterTest() {
        val ironManEnhancer = Enhancer()
        ironManEnhancer.setSuperclass(IronMan::class.java)
        ironManEnhancer.setCallbackFilter(FlyableCallbackFilter())
        ironManEnhancer.setCallbacks(
            arrayOf(
                FlyInterceptor(),
                FallInterceptor(),
                NoOp.INSTANCE // default
            )
        )
        val ironMan = ironManEnhancer.create() as IronMan
        println("fly")
        ironMan.fly()
        println("fall")
        ironMan.fall()
    }
}