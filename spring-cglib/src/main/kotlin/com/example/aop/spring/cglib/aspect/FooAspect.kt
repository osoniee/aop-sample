package com.example.aop.spring.cglib.aspect

import com.example.aop.spring.cglib.annotation.Logged
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory

@Aspect
class FooAspect {
    @Pointcut("@annotation(logged)")
    fun loggedPointcut(logged: Logged) = Unit

    @Around("loggedPointcut(logged)")
    fun logAround(joinPoint: ProceedingJoinPoint, logged: Logged): Any {
        val log = LoggerFactory.getLogger(joinPoint.getThis().javaClass)
        log.debug("-------around @Logged start-------")
        val r = joinPoint.proceed()
        log.debug("-------around @Logged end---------")
        return r
    }
}