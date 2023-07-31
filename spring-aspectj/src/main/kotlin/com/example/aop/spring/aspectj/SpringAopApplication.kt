package com.example.aop.spring.aspectj

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.EnableLoadTimeWeaving
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@Configuration
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ, proxyTargetClass = true)
@EnableAspectJAutoProxy
@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
class SpringAopApplication

fun main(args: Array<String>) {
    runApplication<SpringAopApplication>(*args)
}
