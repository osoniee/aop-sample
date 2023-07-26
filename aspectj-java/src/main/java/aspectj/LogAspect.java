package aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect {
    @Pointcut("@annotation(logged)")
    public void loggedPointCut(Logged logged) { }

    @Around("loggedPointCut(logged)")
    public Object logAround(ProceedingJoinPoint joinPoint, Logged logged) throws Throwable {
        if (!logged.logAround()) return joinPoint.proceed();
        Object returnValue;
        System.out.println("_____________around start____________");
        returnValue = joinPoint.proceed();
        System.out.println("_____________around end______________");
        return returnValue;
    }

    @Before("loggedPointCut(logged)")
    public void logBefore(Logged logged) {
        if (!logged.logBefore()) return;
        System.out.println("_____________before__________________");
    }

    @After("loggedPointCut(logged)")
    public void logAfter(Logged logged) {
        if (!logged.logAfter()) return;
        System.out.println("_____________after___________________");
    }
}
