import avengers.IronMan
import org.junit.jupiter.api.Test

class AspectTest {
    @Test
    fun aspectjTest() {
        val ironMan = IronMan()
        ironMan.fly()
        ironMan.fall()
    }
}