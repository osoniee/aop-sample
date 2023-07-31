package com.example.aop.spring.aspectj

import com.example.aop.spring.aspectj.service.FooService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FooTest {
    @Autowired private lateinit var fooService: FooService

    @Test
    fun startTransactionTest() = fooService.startTransaction()

    @Test
    fun invokeSelfTransactionTest() = fooService.invokeSelfTransaction()

    @Test
    fun registerTest() {
        fooService.registerWithTransaction()

    }

    @Test
    fun selfInvokeRegisterTest() {
        fooService.invokeSelfRegistration()
    }
}