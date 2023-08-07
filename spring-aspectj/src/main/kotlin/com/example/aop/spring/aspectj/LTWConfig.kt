package com.example.aop.spring.aspectj

import com.example.aop.spring.aspectj.aspect.LogAspect
import org.springframework.context.annotation.*
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableAspectJAutoProxy
@EnableLoadTimeWeaving
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
class LTWConfig {
    @Bean
    fun aspect() = LogAspect()
}