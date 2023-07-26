import fly.IronMan;
import org.junit.jupiter.api.Test;

class AspectjTest {
    @Test
    void aspectjTest() {
        IronMan ironMan = new IronMan();
        ironMan.fly();
        ironMan.fall();
    }
}
