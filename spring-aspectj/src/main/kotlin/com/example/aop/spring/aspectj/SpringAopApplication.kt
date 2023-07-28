package com.example.aop.spring.aspectj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@SpringBootApplication
//@EnableAspectJAutoProxy
class SpringAopApplication

fun main(args: Array<String>) {
    runApplication<SpringAopApplication>(*args)
}