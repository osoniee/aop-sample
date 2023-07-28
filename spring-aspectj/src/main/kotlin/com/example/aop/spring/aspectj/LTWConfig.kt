package com.example.aop.spring.aspectj

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableLoadTimeWeaving
import org.springframework.context.annotation.LoadTimeWeavingConfigurer
import org.springframework.instrument.classloading.LoadTimeWeaver
import org.springframework.instrument.classloading.ReflectiveLoadTimeWeaver

@Configuration
@EnableLoadTimeWeaving
class LTWConfig: LoadTimeWeavingConfigurer {
    override fun getLoadTimeWeaver(): LoadTimeWeaver = ReflectiveLoadTimeWeaver()
}