package com.example.aop.spring.aspectj

import org.springframework.context.annotation.*
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver
import org.springframework.instrument.classloading.LoadTimeWeaver

@Configuration
class LTWConfig: LoadTimeWeavingConfigurer {
    override fun getLoadTimeWeaver(): LoadTimeWeaver = InstrumentationLoadTimeWeaver()

}