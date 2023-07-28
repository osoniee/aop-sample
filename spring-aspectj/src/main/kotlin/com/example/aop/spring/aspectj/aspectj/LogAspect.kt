package aspectj

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*

@Aspect
class LogAspect {
    @Pointcut("@annotation(logged)")
    fun loggedPointCut(logged: Logged?) {}

    @Throws(Throwable::class)
    @Around("loggedPointCut(logged)")
    fun logAround(joinPoint: ProceedingJoinPoint, logged: Logged): Any? {
        if (!logged.logAround) return joinPoint.proceed()
        println("_____________around start____________")
        val returnValue: Any? = joinPoint.proceed()
        println("_____________around end______________")
        return returnValue
    }

    @Before("loggedPointCut(logged)")
    fun logBefore(logged: Logged) {
        if (!logged.logBefore) return
        println("_____________before__________________")
    }

    @After("loggedPointCut(logged)")
    fun logAfter(logged: Logged) {
        if (!logged.logAfter) return
        println("_____________after___________________")
    }
}