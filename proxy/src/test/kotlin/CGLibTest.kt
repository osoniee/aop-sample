import fly.IronMan
import net.sf.cglib.proxy.Enhancer
import org.junit.jupiter.api.Test
import proxy.CGLibInvocationHandler

class CGLibTest {
    @Test
    fun invocationHandlerTest() {
        val ironManEnhancer = Enhancer()
        ironManEnhancer.setSuperclass(IronMan::class.java)
        ironManEnhancer.setCallback(CGLibInvocationHandler(IronMan()))
        val ironMan = ironManEnhancer.create() as IronMan

        println("fly")
        ironMan.fly()
        println("fall")
        ironMan.fall()
    }
}