package com.example.lombok.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
@Slf4j
public class GetterAspect {
    @Pointcut("call(* com.example.lombok.avenger.Captain.getMotto())")
    public void callGetPointCut() {}

    @Around("callGetPointCut()")
    public Object arountGetCall(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---------------------------------------");
        log.info("around getter");
        Object returnValue = joinPoint.proceed();
        log.info("after getter: " + returnValue.toString());
        System.out.println("---------------------------------------");
        return returnValue;
    }
}
