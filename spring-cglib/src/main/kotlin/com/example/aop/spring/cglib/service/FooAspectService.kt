package com.example.aop.spring.cglib.service

import com.example.aop.spring.cglib.annotation.Logged
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class FooAspectService {
    private val log = LoggerFactory.getLogger(this::class.java)
    @Logged
    fun runLogged() = log.debug("---------run function annotated @Logged----------")
}