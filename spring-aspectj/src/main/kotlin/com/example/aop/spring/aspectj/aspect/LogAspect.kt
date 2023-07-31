package com.example.aop.spring.aspectj.aspect

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.springframework.stereotype.Component

@Aspect
@Component
open class LogAspect {
    @Pointcut("@annotation(logged)")
    fun loggedPointCut(logged: Logged?) {}

    @Before("loggedPointCut(logged)")
    open fun logBefore(logged: Logged) {
        if (!logged.logBefore) return
        println("_____________before__________________")
    }

    @After("loggedPointCut(logged)")
    open fun logAfter(logged: Logged) {
        if (!logged.logAfter) return
        println("_____________after___________________")
    }
}